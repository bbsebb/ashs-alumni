import { Injectable } from '@angular/core';
import {RouterStateSnapshot, TitleStrategy} from '@angular/router';
import {Title} from '@angular/platform-browser';

@Injectable({
  providedIn: 'root'
})
export class TemplatePageTitleStrategy extends TitleStrategy {

  private static defaultTitle: string = 'Alumni';

  constructor(private readonly title: Title) {
    super();
  }

  override updateTitle(routerState: RouterStateSnapshot): void {
    const title = this.buildTitle(routerState);
    if (title !== undefined) {
      // On définit ici le format : "Nom de la page - Mon Application"
      this.title.setTitle(`${title} - ${TemplatePageTitleStrategy.defaultTitle}`);
    } else {
      // Titre par défaut si aucun 'title' n'est défini dans la route
      this.title.setTitle(`${TemplatePageTitleStrategy.defaultTitle}`);
    }
    }


}
