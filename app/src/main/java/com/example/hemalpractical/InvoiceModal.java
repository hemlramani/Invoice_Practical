package com.example.hemalpractical;

public class InvoiceModal {

    String invocename;
    String invoicetotal;

    public InvoiceModal(String invocename, String invoicetotal) {
        this.invocename = invocename;
        this.invoicetotal = invoicetotal;
    }

    public String getInvocename() {
        return invocename;
    }

    public void setInvocename(String invocename) {
        this.invocename = invocename;
    }

    public String getInvoicetotal() {
        return invoicetotal;
    }

    public void setInvoicetotal(String invoicetotal) {
        this.invoicetotal = invoicetotal;
    }
}
