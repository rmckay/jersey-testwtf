package com.mckay.orders
import javax.xml.bind.annotation.*


/**
 * Created by rm on 11/01/2018.
 *
 *
 * <?xml version="1.0" encoding="UTF-8"?>
 * <tns:purchaseOrder xsi:schemaLocation="http://www.r3.com/PO PO.xsd " xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:tns="http://www.r3.com/PO">
 * <tns:PurchaseOrder>4500017020</tns:PurchaseOrder>
 * <tns:SendingCompanyCode>8100</tns:SendingCompanyCode>
 * <tns:SupplierBusinessPartner>1000200 â€“ General Supplier Blockchain</tns:SupplierBusinessPartner>
 * <tns:Currency>GBP</tns:Currency>
 * <tns:PODate>2018-01-15</tns:PODate>
 * <tns:Quantity>10</tns:Quantity>
 * <tns:Amount>50</tns:Amount>
 * <tns:PaymentTerm>NT30</tns:PaymentTerm>
 * <tns:ShortText>Services 100-200</tns:ShortText>
 * </tns:purchaseOrder>
 *
 */

@XmlRootElement(name="purchaseOrder")
data class PurchaseOrder(
        @XmlElement(name="PurchaseOrder") var PurchaseOrder: String? = "",
        @XmlElement(name="SendingCompanyCode") var SendingCompanyCode: String? = "",
        @XmlElement(name="SupplierBusinessPartner") var SupplierBusinessPartner: String? = "",
        @XmlElement(name="Currency") var Currency: String? = "",
        @XmlElement(name="PODate") var PODate: String? = "",
        @XmlElement(name="Quantity") var Quantity: String? = "",
        @XmlElement(name="Amount") var Amount: String? = "",
        @XmlElement(name="PaymentTerms") var PaymentTerms: String? = "",
        @XmlElement(name="ShortText") var ShortText: String? = ""
)


