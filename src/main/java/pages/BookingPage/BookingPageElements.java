/*
 * Author: Susan Hudson
 */

package pages.BookingPage;

import core.Element;
import core.ElementFindService;

import java.io.IOException;

import org.openqa.selenium.By;

public class BookingPageElements {
    private final ElementFindService elementFindService;

    public BookingPageElements(ElementFindService elementFindService) {
        this.elementFindService = elementFindService;
    }

    public Element availableFunds() throws IOException {
        return elementFindService.findElement(By.id("AvailableFund"));
    }

    public Element withdrawalAmountTextBox() throws IOException {
        return elementFindService.findElement(By.id("withdrawal_amount"));
    }
    
    public Element bankAccountNameTextBox() throws IOException {
        return elementFindService.findElement(By.id("Name"));
    }
    
    public Element bankAccountNumberTextBox() throws IOException {
        return elementFindService.findElement(By.id("AccountNumber"));
    }
    
    public Element sortcodeTextBox() throws IOException {
        return elementFindService.findElement(By.id("SortCode"));
    }
    
    public Element passwordTextBox() throws IOException {
        return elementFindService.findElement(By.id("Password"));
    }


    public Element makeWithdrawalButton() throws IOException {
        return elementFindService.findElement(By.id("btnWithdraw"));
    }


    public Element outstandingWithdrawalMessage() throws IOException {
        return elementFindService.findElement(By.id("successMsg"));
    }

    public Element successfulWithdrawalMessage() throws IOException {
        return elementFindService.findElement(By.xpath("/html/body/div[2]/main/section[2]/div/div/div[2]/div[1]/div/form/p[1]"));
    }


}

