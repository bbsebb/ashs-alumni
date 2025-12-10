import { AbstractControl, ValidationErrors, ValidatorFn } from '@angular/forms';

/**
 * Validateur spécifique qui vérifie que les valeurs des champs 'password' et 'confirmPassword' correspondent.
 */
export const passwordMatchValidator: ValidatorFn = (
  control: AbstractControl
): ValidationErrors | null => {
  const password = control.get('password');
  const confirmPassword = control.get('confirmPassword');

  // Si l'un des contrôles n'existe pas ou n'a pas été touché (facultatif mais bonne pratique)
  if (!password || !confirmPassword) {
    return null;
  }

  // S'il y a déjà une erreur 'required' ou autre sur le champ principal, on ne fait rien
  if (confirmPassword.errors && confirmPassword.errors['passwordMismatch']) {
    return null;
  }

  // Vérifie si les valeurs correspondent
  if (password.value !== confirmPassword.value) {
    // Si elles ne correspondent pas, on met l'erreur sur le champ de confirmation
    confirmPassword.setErrors({ passwordMismatch: true });
    // Le FormGroup ne renvoie pas d'erreur dans ce cas, mais l'erreur est sur le contrôle enfant
    return { passwordMismatch: true }; // On peut aussi mettre l'erreur ici pour le groupe si on veut une erreur globale
  } else {
    // Si elles correspondent, enlève l'erreur 'passwordMismatch' du champ de confirmation s'il y en a une
    if (confirmPassword.hasError('passwordMismatch')) {
      // Pour être sûr de ne pas supprimer d'autres erreurs, on ne garde que ce qui n'est PAS 'passwordMismatch'
      const errors = confirmPassword.errors;
      if (errors) {
        delete errors['passwordMismatch'];
        confirmPassword.setErrors(Object.keys(errors).length === 0 ? null : errors);
      }
    }
    // Les validations sont réussies
    return null;
  }
};
