package fr.hoenheimsports.domain.models;

/**
 * Represents the various states of an SMS message throughout its lifecycle.
 * 
 * <p>This enum defines all possible statuses that an SMS can have, from initial queuing
 * to final delivery or failure. The states follow a specific flow pattern:
 * 
 * <h3>Normal Flow:</h3>
 * <pre>
 * QUEUED → ACCEPTED → SENDING → SENT → DELIVERED → READ
 * </pre>
 * 
 * <h3>Alternative Initial States:</h3>
 * <ul>
 *   <li>Messages can be {@code SCHEDULED} for future delivery</li>
 *   <li>Scheduled messages can be {@code CANCELED} before sending</li>
 * </ul>
 * 
 * <h3>Error States:</h3>
 * <ul>
 *   <li>{@code FAILED} - Message sending failed at any point</li>
 *   <li>{@code UNDELIVERED} - Message was sent but could not be delivered</li>
 * </ul>
 * 
 * <h3>State Transitions:</h3>
 * <ul>
 *   <li>Initial states: {@code QUEUED}, {@code ACCEPTED}, {@code SCHEDULED}</li>
 *   <li>Processing: {@code SENDING}</li>
 *   <li>Success completion: {@code SENT} → {@code DELIVERED} → {@code READ}</li>
 *   <li>Failure states: {@code FAILED}, {@code UNDELIVERED}, {@code CANCELED}</li>
 *   <li>Unknown: {@code UNKNOWN} for unrecognized statuses</li>
 * </ul>
 * 
 * @author Generated for ASHS Alumni Backend
 * @since 1.0
 */
public enum SMSStatus {
    
    // === INITIAL STATES ===
    
    /**
     * Message has been queued for sending.
     * This is typically the first state when a message is created but not yet processed.
     */
    QUEUED,
    
    /**
     * Message has been accepted by the messaging service for processing.
     * This indicates the message has passed initial validation and is ready to be sent.
     */
    ACCEPTED,
    
    /**
     * Message has been scheduled for future delivery.
     * The message will remain in this state until the scheduled time arrives.
     */
    SCHEDULED,
    
    // === PROCESSING STATES ===
    
    /**
     * Message is currently being sent.
     * This is a transitional state between acceptance and successful sending.
     */
    SENDING,
    
    // === SUCCESS STATES ===
    
    /**
     * Message has been successfully sent from the messaging service.
     * This means the message left our system but delivery to the recipient is not yet confirmed.
     */
    SENT,
    
    /**
     * Message has been successfully delivered to the recipient's device.
     * This confirmation comes from the mobile network operator.
     */
    DELIVERED,
    
    /**
     * Message has been read by the recipient.
     * This status is only available when the recipient's device supports read receipts.
     */
    READ,
    
    // === ERROR STATES ===
    
    /**
     * Message sending failed.
     * This can occur at any point in the process due to various reasons
     * (invalid number, network issues, service problems, etc.).
     */
    FAILED,
    
    /**
     * Message was sent but could not be delivered to the recipient.
     * This typically happens when the recipient's phone is off, out of coverage,
     * or the number is invalid.
     */
    UNDELIVERED,
    
    /**
     * Scheduled message was canceled before being sent.
     * This can happen when a user cancels a scheduled message or due to system policies.
     */
    CANCELED,
    
    // === FALLBACK STATE ===
    
    /**
     * Unknown or unrecognized status.
     * Used as a fallback when the messaging service returns a status
     * that is not mapped to any of the above states.
     */
    UNKNOWN
}
