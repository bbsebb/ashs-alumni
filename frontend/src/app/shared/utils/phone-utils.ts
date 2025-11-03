/**
 * Utility class for phone number formatting operations.
 */
export class PhoneUtils {
  private static readonly FRENCH_PREFIX = '+33';
  private static readonly LOCAL_PREFIX = '0';
  private static readonly WHITESPACE_REGEX = /\s/g;

  /**
   * Formate le numéro de téléphone en ajoutant le préfixe +33.
   * Retire les espaces et le 0 initial si présent.
   * @param phone - Le numéro de téléphone à formater
   * @returns Le numéro de téléphone formaté avec le préfixe +33, ou null si vide
   */
  static formatPhoneNumberWithPrefix(phone: string | null): string | null {
    if (this.isPhoneEmpty(phone)) {
      return null;
    }

    let formattedPhone = this.cleanPhone(phone!);

    if (formattedPhone.startsWith(this.LOCAL_PREFIX)) {
      formattedPhone = formattedPhone.substring(1);
    }

    if (!formattedPhone.startsWith(this.FRENCH_PREFIX)) {
      formattedPhone = this.FRENCH_PREFIX + formattedPhone;
    }

    return formattedPhone;
  }

  /**
   * Retire le préfixe international +33 et remet le numéro au format local avec 0 initial.
   * @param phone - Le numéro de téléphone avec préfixe international
   * @returns Le numéro de téléphone au format local (ex: 0612345678), ou null si vide
   */
  static removePhoneNumberPrefix(phone: string | null): string | null {
    if (this.isPhoneEmpty(phone)) {
      return null;
    }

    let formattedPhone = this.cleanPhone(phone!);

    if (formattedPhone.startsWith(this.FRENCH_PREFIX)) {
      formattedPhone = this.LOCAL_PREFIX + formattedPhone.substring(3);
    } else if (!formattedPhone.startsWith(this.LOCAL_PREFIX)) {
      formattedPhone = this.LOCAL_PREFIX + formattedPhone;
    }

    return formattedPhone;
  }

  /**
   * Vérifie si le numéro de téléphone est vide ou null.
   * @param phone - Le numéro de téléphone à vérifier
   * @returns true si le numéro est vide, false sinon
   */
  private static isPhoneEmpty(phone: string | null): boolean {
    return !phone || phone.trim() === '';
  }

  /**
   * Nettoie le numéro de téléphone en retirant tous les espaces.
   * @param phone - Le numéro de téléphone à nettoyer
   * @returns Le numéro de téléphone sans espaces
   */
  private static cleanPhone(phone: string): string {
    return phone.trim().replace(this.WHITESPACE_REGEX, '');
  }
}
