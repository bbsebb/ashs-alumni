package fr.hoenheimsports.app.services;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmailService {
    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Async
    public void envoyerEmailTexte(
            String destinataire,
            String sujet,
            String contenuHtml
    ) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            // Le 2ème paramètre "utf-8" assure une bonne gestion des accents
            MimeMessageHelper helper = new MimeMessageHelper(message, "utf-8");
            helper.setTo(destinataire);
            helper.setSubject(sujet);
            // Le boolean 'true' indique que le contenu est du HTML
            helper.setText(contenuHtml, true);
            mailSender.send(message);
            log.debug("Email envoyé à {} avec le sujet {}", destinataire, sujet);
        } catch (MessagingException e) {
            log.error("Erreur lors de l'envoi de l'email texte", e);
            throw new RuntimeException("Erreur lors de l'envoi de l'email HTML", e);
        }
    }
}
