export interface ProblemDetail {
  type: type;
  title?: string;
  status?: number;
  detail?: string;
  instance?: string;

  // propriétés supplémentaires dynamiques (la Map<String, Object>)
  [key: string]: unknown;
}

export type type =
  "https://api.hoenheimsports.fr/errors/validation" |
  "https://api.hoenheimsports.fr/errors/unauthorized"|
  "https://api.hoenheimsports.fr/errors/contact-already-exists"|
  "https://api.hoenheimsports.fr/errors/entity-already-removed"|
  "https://api.hoenheimsports.fr/errors/invalid-phone-number"|
  "https://api.hoenheimsports.fr/errors/missing-required-field"|
  "https://api.hoenheimsports.fr/errors/sms-history-not-found"|
  "https://api.hoenheimsports.fr/errors/former-teammate-not-found"|
  "https://api.hoenheimsports.fr/errors/sms-limit-exceeded"|
  "https://api.hoenheimsports.fr/errors/runtime"|
  "https://api.hoenheimsports.fr/errors/internal";

