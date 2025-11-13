package fr.hoenheimsports.app.integrations;

import fr.hoenheimsports.app.controllers.dtos.FormerTeammateHistoryResponse;
import fr.hoenheimsports.app.controllers.dtos.FormerTeammateResponse;
import fr.hoenheimsports.app.controllers.dtos.SMSHistoryResponse;
import fr.hoenheimsports.domain.models.SMSStatus;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Predicate;


public abstract class FormerTeammateIT {


    protected static @NotNull Predicate<FormerTeammateHistoryResponse> isParentFormerTeammateIdEqualForFormerTeammateHistoryResponse(FormerTeammateResponse response) {
        return formerTeammateHistoryResponse -> formerTeammateHistoryResponse.formerTeammateId().equals(response.id());
    }

    protected static @NotNull Predicate<SMSHistoryResponse> isParentFormerTeammateIdEqualForSMSHistoryResponse(FormerTeammateResponse response) {
        return smsHistoryResponse -> smsHistoryResponse.formerTeammateId().equals(response.id());
    }

    protected static @NotNull Predicate<SMSHistoryResponse> isFailedOrHasExternalId() {
        return smsHistoryResponse -> {
            if (smsHistoryResponse.status().equals(SMSStatus.FAILED)) {
                return true;
            } else {
                return smsHistoryResponse.externalId() != null;
            }
        };
    }

    protected static @NotNull Predicate<FormerTeammateHistoryResponse> isUpdatedWithinTimeRange(LocalDateTime testStartTime, LocalDateTime testEndTime) {
        return history -> {
            LocalDateTime updatedAt = history.updatedAt();
            return updatedAt != null &&
                    !updatedAt.isBefore(testStartTime) &&
                    !updatedAt.isAfter(testEndTime.plusSeconds(1));
        };
    }

    protected static @NotNull List<SMSHistoryResponse> filterNewSMSHistory(FormerTeammateResponse response, FormerTeammateResponse contextResponse) {
        return response.SMSHistories()
                .stream()
                .filter(
                        SMSHistoryResponse -> contextResponse.SMSHistories()
                                .stream()
                                .noneMatch(
                                        contextHistory -> contextHistory.id().equals(SMSHistoryResponse.id()
                                        )
                                )
                )
                .toList();
    }

    protected static @NotNull List<SMSHistoryResponse> filterOldSMSHistories(FormerTeammateResponse response, FormerTeammateResponse contextResponse) {
        return response.SMSHistories()
                .stream()
                .filter(
                        SMSHistoryResponse -> contextResponse.SMSHistories()
                                .stream()
                                .anyMatch(
                                        contextHistory -> contextHistory.id().equals(SMSHistoryResponse.id()
                                        )
                                )
                )
                .toList();
    }

    protected static @NotNull List<FormerTeammateHistoryResponse> filterNewTeammateHistoryResponses(FormerTeammateResponse response, FormerTeammateResponse contextResponse) {
        return response.formerTeammateHistories()
                .stream()
                .filter(
                        formerTeammateHistoryResponse -> contextResponse.formerTeammateHistories()
                                .stream()
                                .noneMatch(
                                        contextHistory -> contextHistory.id().equals(formerTeammateHistoryResponse.id()
                                        )
                                )
                )
                .toList();
    }

    protected static @NotNull List<FormerTeammateHistoryResponse> filterOldFormerTeammateHistoryResponses(FormerTeammateResponse response, FormerTeammateResponse contextResponse) {
        return response.formerTeammateHistories()
                .stream()
                .filter(
                        formerTeammateHistoryResponse -> contextResponse.formerTeammateHistories()
                                .stream()
                                .anyMatch(
                                        contextHistory -> contextHistory.id().equals(formerTeammateHistoryResponse.id()
                                        )
                                )
                )
                .toList();
    }
}
