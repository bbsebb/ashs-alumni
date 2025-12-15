package fr.hoenheimsports.app.services;

import fr.hoenheimsports.app.controllers.dtos.FormerTeammateResponse;
import fr.hoenheimsports.app.mappers.FormerTeammateHistoryMapper;
import fr.hoenheimsports.app.mappers.FormerTeammateMapper;
import fr.hoenheimsports.app.mappers.SMSHistoryMapper;
import fr.hoenheimsports.domain.api.GetFormerTeammateHistory;
import fr.hoenheimsports.domain.api.GetSMSHistory;
import fr.hoenheimsports.domain.models.FormerTeammate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormerTeammateService {

    private final FormerTeammateMapper formerTeammateMapper;
    private final GetFormerTeammateHistory getFormerTeammateHistory;
    private final GetSMSHistory getSMSHistory;
    private final FormerTeammateHistoryMapper formerTeammateHistoryMapper;
    private final SMSHistoryMapper smsHistoryMapper;

    public FormerTeammateService(FormerTeammateMapper formerTeammateMapper, 
                               GetFormerTeammateHistory getFormerTeammateHistory, 
                               GetSMSHistory getSMSHistory, 
                               FormerTeammateHistoryMapper formerTeammateHistoryMapper, 
                               SMSHistoryMapper smsHistoryMapper) {
        this.formerTeammateMapper = formerTeammateMapper;
        this.getFormerTeammateHistory = getFormerTeammateHistory;
        this.getSMSHistory = getSMSHistory;
        this.formerTeammateHistoryMapper = formerTeammateHistoryMapper;
        this.smsHistoryMapper = smsHistoryMapper;
    }

    /**
     * Builds a complete FormerTeammateResponse with histories
     *
     * @param formerTeammate the domain model to convert
     * @return complete response with histories included
     */
    public FormerTeammateResponse buildFormerTeammateResponse(FormerTeammate formerTeammate) {
        // Get the basic response from the mapper (without histories)
        var formerTeammateResponse = formerTeammateMapper.toResponse(formerTeammate);
        
        // Retrieve histories using domain services
        var formerTeammateHistories = getFormerTeammateHistory.findAllFormerTeammateHistoryByFormerTeammateId(formerTeammate.id());
        var smsHistories = getSMSHistory.findAllSMSHistoryByFormerTeammateId(formerTeammate.id());
        
        // Map histories to response DTOs
        var formerTeammateHistoryResponses = formerTeammateHistories.stream().map(formerTeammateHistoryMapper::toResponse).toList();
        var smsHistoryResponses = smsHistoryMapper.toResponseList(smsHistories);
        
        // Create a complete response with histories
        return new FormerTeammateResponse(
                formerTeammateResponse.id(),
                formerTeammateResponse.firstName(),
                formerTeammateResponse.lastName(),
                formerTeammateResponse.gender(),
                formerTeammateResponse.phone(),
                formerTeammateResponse.email(),
                formerTeammateResponse.birthDate(),
                formerTeammateResponse.roles(),
                formerTeammateResponse.status(),
                formerTeammateResponse.kcUserId(),
                formerTeammateHistoryResponses,
                smsHistoryResponses
        );
    }

    /**
     * Builds a list of complete FormerTeammateResponse with histories
     *
     * @param formerTeammates list of domain models to convert
     * @return list of complete responses with histories included
     */
    public List<FormerTeammateResponse> buildFormerTeammateResponses(List<FormerTeammate> formerTeammates) {
        return formerTeammates.stream()
                .map(this::buildFormerTeammateResponse)
                .toList();
    }


}