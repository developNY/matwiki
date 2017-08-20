import { browser, by, element } from 'protractor';

export class ProjectMatwikiPage {
  navigateTo() {
    return browser.get('/');
  }

  getParagraphText() {
    return element(by.css('mw-root h1')).getText();
  }
}
