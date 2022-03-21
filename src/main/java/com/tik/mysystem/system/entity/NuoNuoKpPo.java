package com.tik.mysystem.system.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class NuoNuoKpPo {


    private OrderBean order;

    @NoArgsConstructor
    @Data
    public static class OrderBean {
        private String terminalNumber;
        private List<InvoiceDetailBean> invoiceDetail;
        private String buyerTel;
        private String listFlag;
        private String pushMode;
        private String departmentId;
        private String clerkId;
        private String remark;
        private String checker;
        private String payee;
        private String buyerAddress;
        private String buyerTaxNum;
        private String invoiceType;
        private String invoiceLine;
        private String email;
        private String salerAccount;
        private String salerTel;
        private String orderNo;
        private String callBackUrl;
        private String machineCode;
        private String billInfoNo;
        private VehicleInfoBean vehicleInfo;
        private String vehicleFlag;
        private String buyerName;
        private String invoiceDate;
        private String invoiceCode;
        private String invoiceNum;
        private String hiddenBmbbbh;
        private String salerAddress;
        private String clerk;
        private String buyerPhone;
        private String buyerAccount;
        private String productOilFlag;
        private String extensionNumber;
        private String salerTaxNum;
        private String listName;
        private String proxyInvoiceFlag;

        @NoArgsConstructor
        @Data
        public static class VehicleInfoBean {
            private String taxOfficeCode;
            private String manufacturerName;
            private String importCerNum;
            private String certificate;
            private String engineNum;
            private String taxOfficeName;
            private String brandModel;
            private String productOrigin;
            private String vehicleCode;
            private String maxCapacity;
            private String intactCerNum;
            private String tonnage;
            private String insOddNum;
            private String idNumOrgCode;
            private String vehicleType;
        }

        @NoArgsConstructor
        @Data
        public static class InvoiceDetailBean {
            private String specType;
            private String taxExcludedAmount;
            private String invoiceLineProperty;
            private String favouredPolicyName;
            private String num;
            private String withTaxFlag;
            private String tax;
            private String favouredPolicyFlag;
            private String taxRate;
            private String unit;
            private String deduction;
            private String price;
            private String zeroRateFlag;
            private String goodsCode;
            private String selfCode;
            private String goodsName;
            private String taxIncludedAmount;
        }
    }
}
