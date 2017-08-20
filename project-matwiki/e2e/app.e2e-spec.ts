import { ProjectMatwikiPage } from './app.po';

describe('project-matwiki App', () => {
  let page: ProjectMatwikiPage;

  beforeEach(() => {
    page = new ProjectMatwikiPage();
  });

  it('should display welcome message', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('Welcome to mw!');
  });
});
