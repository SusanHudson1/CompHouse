/*
 * Author: Susan Hudson
 */

package pages;

import core.Driver;
import core.ElementFindService;
import pages.Sections.MainMenuSection;

public abstract class StdPage {
    protected final ElementFindService elementFindService;

    public StdPage(Driver driver) {
        this.elementFindService = driver;
    }


    public MainMenuSection mainMenuSection() {
        return new MainMenuSection(elementFindService);
    }

}
