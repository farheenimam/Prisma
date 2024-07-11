package com.prizma.prizma.Purchase;

import com.prizma.prizma.Reader.Reader;
import com.prizma.prizma.Reader.ReaderOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/subscription")
public class PurchaseController {

    private final ReaderOperation readerOperation;

    @Autowired
    public PurchaseController(ReaderOperation readerOperation){
        this.readerOperation = readerOperation;
    }

    @GetMapping
    public String displayForm(Model model) {
        model.addAttribute("reader", new Reader());
        return "subscription";
    }

    @PostMapping
    public String purchaseSubscription(@ModelAttribute Reader reader, RedirectAttributes redirectAttributes) {
        try {
            // Get the selected subscription option
            String selectedSubscription = reader.getSubscription();
            // Split the selected option value into subscription type and price
            String[] subscriptionParts = selectedSubscription.split("\\|");
            String subscriptionType = subscriptionParts[0];
            double subscriptionPrice = Double.parseDouble(subscriptionParts[1]);

            // Set the subscription type and price in the Reader object
            reader.setSubscription(subscriptionType);
            reader.setAmount(subscriptionPrice);

            // Logic to save the subscription
            Reader savedReader = readerOperation.purchase(reader);
            return "redirect:/subscriptionList"; // Redirect to the same page to display success message
        } catch (Exception e) {
            return "redirect:/subscription"; // Redirect to the same page to display error message
        }
    }
}
