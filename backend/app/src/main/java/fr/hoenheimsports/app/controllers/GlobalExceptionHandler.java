package fr.hoenheimsports.app.controllers;

import fr.hoenheimsports.app.exceptions.ParticipantAlreadyExistsException;
import fr.hoenheimsports.domain.exceptions.*;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.security.authorization.AuthorizationDeniedException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URI;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j

@RestControllerAdvice
public class GlobalExceptionHandler  extends ResponseEntityExceptionHandler  {


    // Regroupe toutes les valeurs de ProblemDetail#setType dans un enum unique
    @Getter
    private enum ErrorType {
        VALIDATION("https://api.hoenheimsports.fr/errors/validation"),
        UNAUTHORIZED("https://api.hoenheimsports.fr/errors/unauthorized"),
        PARTICIPANT_ALREADY_EXISTS("https://api.hoenheimsports.fr/errors/participant-already-exists"),
        CONTACT_ALREADY_EXISTS("https://api.hoenheimsports.fr/errors/contact-already-exists"),
        ENTITY_ALREADY_REMOVED("https://api.hoenheimsports.fr/errors/entity-already-removed"),
        INVALID_PHONE_NUMBER("https://api.hoenheimsports.fr/errors/invalid-phone-number"),
        MISSING_REQUIRED_FIELD("https://api.hoenheimsports.fr/errors/missing-required-field"),
        SMS_HISTORY_NOT_FOUND("https://api.hoenheimsports.fr/errors/sms-history-not-found"),
        FORMER_TEAMMATE_NOT_FOUND("https://api.hoenheimsports.fr/errors/former-teammate-not-found"),
        FORMER_TEAMMATE_NOT_REQUESTED("https://api.hoenheimsports.fr/errors/former-teammate-not-requested"),
        SMS_LIMIT_EXCEEDED("https://api.hoenheimsports.fr/errors/sms-limit-exceeded"),
        RUNTIME("https://api.hoenheimsports.fr/errors/runtime"),
        INTERNAL("https://api.hoenheimsports.fr/errors/internal");

        private final URI uri;

        ErrorType(String uri) {
            this.uri = URI.create(uri);
        }

    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid( MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        String title = "Champs erronés";
        log.error(title, ex);
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
                HttpStatus.BAD_REQUEST,
                "Erreur de validation des données"
        );

        problemDetail.setType(ErrorType.VALIDATION.getUri());
        problemDetail.setTitle(title);

        BindingResult bindingResult = ex.getBindingResult();

        // 1. Erreurs de champs individuels
        List<Map<String, Object>> fieldErrors = bindingResult.getFieldErrors()
                .stream()
                .map(error -> {
                    Map<String, Object> errorDetail = new HashMap<>();
                    errorDetail.put("type", "field");
                    errorDetail.put("field", error.getField());
                    errorDetail.put("message", error.getDefaultMessage());
                    errorDetail.put("rejectedValue", error.getRejectedValue());
                    errorDetail.put("code", error.getCode());
                    return errorDetail;
                })
                .toList();

        // 2. Erreurs globales (contraintes sur plusieurs champs)
        List<Map<String, Object>> globalErrors = bindingResult.getGlobalErrors()
                .stream()
                .map(error -> {
                    Map<String, Object> errorDetail = new HashMap<>();
                    errorDetail.put("type", "global");
                    errorDetail.put("objectName", error.getObjectName());
                    errorDetail.put("message", error.getDefaultMessage());
                    errorDetail.put("code", error.getCode());
                    return errorDetail;
                })
                .toList();

        // Combiner les deux types d'erreurs
        List<Map<String, Object>> allErrors = new ArrayList<>();
        allErrors.addAll(fieldErrors);
        allErrors.addAll(globalErrors);

        problemDetail.setProperty("errors", allErrors);
        problemDetail.setProperty("fieldErrorCount", fieldErrors.size());
        problemDetail.setProperty("globalErrorCount", globalErrors.size());
        problemDetail.setProperty("totalErrorCount", allErrors.size());
        problemDetail.setProperty("timestamp", Instant.now());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(problemDetail);
    }

    @ExceptionHandler(CurrentUserMissingException.class)
    public ProblemDetail handleCurrentUserMissingException(CurrentUserMissingException ex) {
        String title = "Permission utilisateur manquante";
        log.error(title, ex);
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
                HttpStatus.UNAUTHORIZED,
                ex.getMessage()
        );
        problemDetail.setType(ErrorType.UNAUTHORIZED.getUri());
        problemDetail.setTitle(title);
        problemDetail.setProperty("timestamp", Instant.now());
        return problemDetail;
    }


    @ExceptionHandler(AuthorizationDeniedException.class)
    public ProblemDetail handleAuthorizationDeniedException(AuthorizationDeniedException ex) {
        String title = "Authorisation manquante";
        log.error(title, ex);
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
                HttpStatus.UNAUTHORIZED,
                "Vous n'avez pas les autorisations requises"
        );
        problemDetail.setType(ErrorType.UNAUTHORIZED.getUri());
        problemDetail.setTitle(title);
        problemDetail.setProperty("timestamp", Instant.now());
        return problemDetail;
    }

    @ExceptionHandler(FormerTeammateAlreadyExistsException.class)
    public ProblemDetail handleFormerTeammateAlreadyExistsException(FormerTeammateAlreadyExistsException ex) {
        String title = "Le contact existe déjà";
        log.error(title, ex);
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
                HttpStatus.CONFLICT,
                ex.getMessage()
        );
        problemDetail.setType(ErrorType.CONTACT_ALREADY_EXISTS.getUri());
        problemDetail.setTitle(title);
        problemDetail.setProperty("timestamp", Instant.now());
        return problemDetail;
    }

    @ExceptionHandler(ParticipantAlreadyExistsException.class)
    public ProblemDetail handleParticipantAlreadyExistsException(ParticipantAlreadyExistsException ex) {
        String title = "Le participant existe déjà";
        log.error(title, ex);
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
                HttpStatus.CONFLICT,
                ex.getMessage()
        );
        problemDetail.setType(ErrorType.CONTACT_ALREADY_EXISTS.getUri());
        problemDetail.setTitle(title);
        problemDetail.setProperty("timestamp", Instant.now());
        return problemDetail;
    }

    @ExceptionHandler(FormerTeammateForbiddenByStatusException.class)
    public ProblemDetail handleFormerTeammateForbiddenByStatusException(FormerTeammateForbiddenByStatusException ex) {
        String title = "Le contact est marqué comme « NON SOLLICITÉ »";
        log.error(title, ex);
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
                HttpStatus.CONFLICT,
                ex.getMessage()
        );
        problemDetail.setType(ErrorType.FORMER_TEAMMATE_NOT_REQUESTED.getUri());
        problemDetail.setTitle(title);
        problemDetail.setProperty("timestamp", Instant.now());
        return problemDetail;
    }

    @ExceptionHandler(FormerTeammateAlreadyRemoved.class)
    public ProblemDetail handleFormerTeammateAlreadyRemoved(FormerTeammateAlreadyRemoved ex) {
        String title = "Le contact a déjà été supprimé";
        log.error(title, ex);
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
                HttpStatus.GONE,
                ex.getMessage()
        );
        problemDetail.setType(ErrorType.ENTITY_ALREADY_REMOVED.getUri());
        problemDetail.setTitle(title);
        problemDetail.setProperty("timestamp", Instant.now());
        return problemDetail;
    }

    @ExceptionHandler(InvalidPhoneNumberException.class)
    public ProblemDetail handleInvalidPhoneNumberException(InvalidPhoneNumberException ex) {
        String title = "Le numéro de téléphone est invalide";
        log.error(title, ex);
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
                HttpStatus.BAD_REQUEST,
                ex.getMessage()
        );
        problemDetail.setType(ErrorType.INVALID_PHONE_NUMBER.getUri());
        problemDetail.setTitle(title);
        problemDetail.setProperty("timestamp", Instant.now());
        return problemDetail;
    }

    //Ne dois jamais arriver, la validation au niveau du controller arrive avant
    @ExceptionHandler(MissingRequiredFieldException.class)
    public ProblemDetail handleMissingRequiredFieldException(MissingRequiredFieldException ex) {
        String title = "Un champs requis est manquant";
        log.error(title, ex);
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
                HttpStatus.BAD_REQUEST,
                ex.getMessage()
        );
        problemDetail.setType(ErrorType.MISSING_REQUIRED_FIELD.getUri());
        problemDetail.setTitle(title);
        problemDetail.setProperty("timestamp", Instant.now());
        return problemDetail;
    }


    @ExceptionHandler(SMSHistoryRepositoryException.class)
    public ProblemDetail handleSMSHistoryRepositoryException(SMSHistoryRepositoryException ex) {
        String title = "L'historique d'envoie des sms non trouvé";
        log.error(title, ex);
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
                HttpStatus.BAD_REQUEST,
                ex.getMessage()
        );
        problemDetail.setType(ErrorType.SMS_HISTORY_NOT_FOUND.getUri());
        problemDetail.setTitle(title);
        problemDetail.setProperty("timestamp", Instant.now());
        return problemDetail;
    }

    @ExceptionHandler(FormerTeammateNotFoundException.class)
    public ProblemDetail handleFormerTeammateNotFoundException(FormerTeammateNotFoundException ex) {
        String title = "Le contact n'existe pas ou n'a pas été trouvé";
        log.error(title, ex);
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
                HttpStatus.NOT_FOUND,
                ex.getMessage()
        );
        problemDetail.setType(ErrorType.FORMER_TEAMMATE_NOT_FOUND.getUri());
        problemDetail.setTitle(title);
        problemDetail.setProperty("timestamp", Instant.now());
        return problemDetail;
    }

    @ExceptionHandler(SMSLimitExceededException.class)
    public ProblemDetail handleSMSLimitExceededException(SMSLimitExceededException ex) {
        String title = "Envoi maximal de SMS pour un contact";
        log.error(title, ex);
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
                HttpStatus.TOO_MANY_REQUESTS,
                ex.getMessage()
        );
        problemDetail.setType(ErrorType.SMS_LIMIT_EXCEEDED.getUri());
        problemDetail.setTitle(title);
        problemDetail.setProperty("timestamp", Instant.now());
        return problemDetail;
    }

    @ExceptionHandler(RuntimeException.class)
    public ProblemDetail handleGeneralRuntimeException(RuntimeException ex) {
        String title = "Une erreur runtime s'est produite";
        log.error(title, ex);
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
                HttpStatus.INTERNAL_SERVER_ERROR,
                "Une erreur d'exécution inattendue s'est produite !"
        );
        problemDetail.setType(ErrorType.RUNTIME.getUri());
        problemDetail.setTitle(title);
        problemDetail.setProperty("timestamp", Instant.now());
        return problemDetail;
    }



    @ExceptionHandler(Exception.class)
    public ProblemDetail handleGeneralException(Exception ex) {
        String title = "Une erreur interne s'est produite";
        log.error(title, ex);
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
                HttpStatus.INTERNAL_SERVER_ERROR,
                "Une erreur interne s'est produite !"
        );
        problemDetail.setType(ErrorType.INTERNAL.getUri());
        problemDetail.setTitle(title);
        problemDetail.setProperty("timestamp", Instant.now());

        return problemDetail;
    }
}
