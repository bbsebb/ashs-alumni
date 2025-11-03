export type SMSStatus =
// Initial states
  | 'QUEUED'
  | 'ACCEPTED'
  | 'SCHEDULED'
  // Processing states
  | 'SENDING'
  // Success states
  | 'SENT'
  | 'DELIVERED'
  | 'READ'
  // Error states
  | 'FAILED'
  | 'UNDELIVERED'
  | 'CANCELED'
  // Fallback
  | 'UNKNOWN';
