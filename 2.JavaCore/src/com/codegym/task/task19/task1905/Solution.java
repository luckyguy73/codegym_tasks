package com.codegym.task.task19.task1905;

import java.util.HashMap;
import java.util.Map;

/* 
Reinforce the adapter
*/

public class Solution {
    public static Map<String,String> countries = new HashMap<>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("US", "United States");
        countries.put("FR", "France");
    }

    public static class DataAdapter implements RowItem {
        private final Customer customer;
        private final Contact contact;

        public DataAdapter(Customer customer, Contact contact) {
            this.customer = customer;
            this.contact = contact;
        }

        @Override
        public String getCountryCode() {
            return countries.entrySet().stream().filter(e -> e.getValue().equals(customer.getCountryName()))
                    .map(Map.Entry::getKey).findFirst().orElse(null);
        }

        @Override
        public String getCompany() {
            return customer.getCompanyName();
        }

        @Override
        public String getContactFirstName() {
            return contact.getName().substring(contact.getName().indexOf(",") + 2);
        }

        @Override
        public String getContactLastName() {
            return contact.getName().substring(0, contact.getName().indexOf(","));
        }

        @Override
        public String getDialString() {
            return "callto://" + contact.getPhoneNumber().replace("-", "").replace("(", "").replace(")", "");
        }
    }

    public static interface RowItem {
        String getCountryCode();        // For example: US
        String getCompany();            // For example: CodeGym Ltd.
        String getContactFirstName();   // For example: John
        String getContactLastName();    // For example: Peterson
        String getDialString();         // For example: callto://+11112223333
    }

    public static interface Customer {
        String getCompanyName();        // For example: CodeGym Ltd.
        String getCountryName();        // For example: United States
    }

    public static interface Contact {
        String getName();               // For example: Peterson, John
        String getPhoneNumber();        // For example: +1(111)222-3333, +3(805)0123-4567, +380(50)123-4567, etc.
    }

    public static void main(String[] args) {

    }
}






