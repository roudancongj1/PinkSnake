package com.pk.commonserver.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * Business Structure: Business.  All kinds of Business (all Levels of Business, all Types of Business, all Life Cycle Statuses), among them Inward and Outward Business; Cedent's Contract and Outward Cedent's Contract.
 * </p>
 *
 * @author Gao
 * @since 2022-09-26
 */
@Getter
@Setter
@TableName("BUSINESS")
@ApiModel(value = "Business对象", description = "Business Structure: Business.  All kinds of Business (all Levels of Business, all Types of Business, all Life Cycle Statuses), among them Inward and Outward Business; Cedent's Contract and Outward Cedent's Contract.")
public class Business implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("A Version 4 Random UUID. Prior to SICS v4.8.6, a Version 1 date-time and MAC address UUID.")
      @TableId("OBJECT_ID")
    private String objectId;

    @ApiModelProperty("Suffix of the identifier of the Business.")
    @TableField("ID_SUFFIX")
    private String idSuffix;

    @ApiModelProperty("Serie number of the identifier of the Business.")
    @TableField("ID_SERIE_NO")
    private Long idSerieNo;

    @ApiModelProperty("Inception Date. Start date of first (oldest) definite insured period.")
    @TableField("INCEPTION_DATE")
    private LocalDateTime inceptionDate;

    @ApiModelProperty("Cancellation Date.")
    @TableField("CANCELLATION_DATE")
    private LocalDateTime cancellationDate;

    @ApiModelProperty("Boolean (Y/N) - Is Cease Accounting set on Business level.  True means that all Insured periods have Cease Accounting set to true.")
    @TableField("IS_CEASE_ACC")
    private String isCeaseAcc;

    @ApiModelProperty("Boolean (Y/N) - True means that business is a dummy business used in EDI.")
    @TableField("IS_EDI_GEN_COVER")
    private String isEdiGenCover;

    @ApiModelProperty("Boolean (Y/N) - Is Allocation Of External BP allowed  set on Business level.  True means that External BP are allowed.")
    @TableField("IS_ALLOC_EXTBP_BAL")
    private String isAllocExtbpBal;

    @ApiModelProperty("Boolean (Y/N) - Is Allocation Of Recipient allowed  set on Business level")
    @TableField("IS_ALLOC_RCPNT_BAL")
    private String isAllocRcpntBal;

    @ApiModelProperty("Boolean (Y/N) - This column is not in use, and may be removed in a future release.")
    @TableField("IS_COINSURANCE")
    private String isCoinsurance;

    @ApiModelProperty("Boolean (Y/N) - Is Single Treaty Protection.  Used only if Type of Business is Treaty (Proportional or Non-proportional.  True means that only one Business is covered by this Business")
    @TableField("IS_SINGLE_RETRO")
    private String isSingleRetro;

    @ApiModelProperty("Last complete accounting year for this business")
    @TableField("LST_CMPL_ACC_YEAR")
    private Integer lstCmplAccYear;

    @ApiModelProperty("Date - Last complete accounting period")
    @TableField("LST_CMPL_ACC_DATE")
    private LocalDateTime lstCmplAccDate;

    @ApiModelProperty("Last complete booking year")
    @TableField("LST_CMPL_BK_YEAR")
    private Integer lstCmplBkYear;

    @ApiModelProperty("Date for last complete account")
    @TableField("DT_LST_CMPL_ACC_YR")
    private LocalDateTime dtLstCmplAccYr;

    @ApiModelProperty("Finished booking year for this business")
    @TableField("FINISHED_BKNG_YEAR")
    private Integer finishedBkngYear;

    @ApiModelProperty("Date for last complete booking year")
    @TableField("LST_CMPL_BK_DATE")
    private LocalDateTime lstCmplBkDate;

    @ApiModelProperty("Boolean (Y/N) - Is Financing Re Arrangement (Life Specific)")
    @TableField("FINANCING_RE")
    private String financingRe;

    @ApiModelProperty("Boolean (Y/N) - Is Financial Risk/Re Combo (Life Specific)")
    @TableField("FIN_RISK_COMBO")
    private String finRiskCombo;

    @ApiModelProperty("Boolean (Y/N) - Is Specific Acceptance")
    @TableField("SPECIAL_ACCEPTANCE")
    private String specialAcceptance;

    @ApiModelProperty("Identifier Serie Number for the Next Placement")
    @TableField("NEXT_ID_FOR_PL")
    private Integer nextIdForPl;

    @ApiModelProperty("Boolean (Y/N) - Is To Be Include In Billing/ReminderStatement")
    @TableField("TO_BE_IN_STATEMENT")
    private String toBeInStatement;

    @ApiModelProperty("Boolean (Y/N) - OCC - Retrocession on a Per Insured basis ?")
    @TableField("RETRO_PER_INSURED")
    private String retroPerInsured;

    @ApiModelProperty("Boolean (Y/N) - Own Retention -  Insured Based Protection ?")
    @TableField("INSURED_BASED_PROT")
    private String insuredBasedProt;

    @ApiModelProperty("Boolean (Y/N) - Should Insured Based Protection premium bookings be generated to this business?")
    @TableField("IBP_GEN_PREM_BOOK")
    private String ibpGenPremBook;

    @ApiModelProperty("Boolean (Y/N) - Should Insured Based Protection claim bookings be generated to this business?")
    @TableField("IBP_GEN_CLAIM_BOOK")
    private String ibpGenClaimBook;

    @ApiModelProperty("Boolean (Y/N) - Should claims booked via the technical worksheet of assumed business be ignored for Insured Based Protection booking to this business")
    @TableField("IBP_NO_TECH_CLAIMS")
    private String ibpNoTechClaims;

    @ApiModelProperty("Boolean (Y/N) - Indicates if the object has already been sent over the interface")
    @TableField("HAS_BEEN_TRIGGERED")
    private String hasBeenTriggered;

    @ApiModelProperty("Boolean (Y/N) - Worksheet Closing Security Limitation")
    @TableField("WK_CLS_SC")
    private String wkClsSc;

    @ApiModelProperty("Cessions Cancelled Date")
    @TableField("CESS_CAN_DATE")
    private LocalDateTime cessCanDate;

    @ApiModelProperty("Claims Cancelled Date")
    @TableField("CLM_CAN_DATE")
    private LocalDateTime clmCanDate;

    @ApiModelProperty("Boolean (Y/N) - Trace Assumed from Outward Bookings")
    @TableField("TRACE_AB")
    private String traceAb;

    @ApiModelProperty("Boolean (Y/N) - Trace Claim from Outward Bookings")
    @TableField("TRACE_CLAIM")
    private String traceClaim;

    @ApiModelProperty("Boolean (Y/N) - Trace Headline Loss from Outward Bookings")
    @TableField("TRACE_HL")
    private String traceHl;

    @ApiModelProperty("Boolean (Y/N) - Trace Base Company from Outward Bookings")
    @TableField("TRACE_BC")
    private String traceBc;

    @ApiModelProperty("Boolean (Y/N) - Automatically Book Figures On Section Level")
    @TableField("AUTO_BOOK_SECT")
    private String autoBookSect;

    @ApiModelProperty("Boolean (Y/N) - Controls generation of Preliminary Bookings")
    @TableField("FLAT_BASED")
    private String flatBased;

    @ApiModelProperty("Boolean (Y/N) - Controls generation of Preliminary Bookings")
    @TableField("CASH_BASED")
    private String cashBased;

    @ApiModelProperty("Boolean (Y/N) - Controls visiblity of PP Condition on Adminstrative Business,PP condition is visible if its Insured's Contract is Adminstrator of Placements")
    @TableField("IS_ADMINISTRATOR")
    private String isAdministrator;

    @ApiModelProperty("Boolean (Y/N) - Is Accounting Review Required")
    @TableField("ACC_REVIEW_REQ")
    private String accReviewReq;

    @ApiModelProperty("Boolean (Y/N) - Is Accounting Review Complete")
    @TableField("ACC_REVIEW_COMPL")
    private String accReviewCompl;

    @ApiModelProperty("Boolean (Y/N) - Is Supporting Business")
    @TableField("IS_SUPPORTING")
    private String isSupporting;

    @ApiModelProperty("Boolean (Y/N) - Is MGU Business")
    @TableField("IS_MGU")
    private String isMgu;

    @ApiModelProperty("Boolean (Y/N) - Reinsurance commission to Co-Insurers")
    @TableField("IS_REIN_COM")
    private String isReinCom;

    @ApiModelProperty("Boolean (Y/N) - Trace Original Responsible Partner from Outward Bookings")
    @TableField("TRACE_ORIG_RP")
    private String traceOrigRp;

    @ApiModelProperty("Non-Liquid Tax on Interest percentage")
    @TableField("TAX_ON_INT")
    private BigDecimal taxOnInt;

    @ApiModelProperty("Boolean (Y/N) - Calculate based on Quota Share Percentage")
    @TableField("IS_QS_BASED")
    private String isQsBased;

    @ApiModelProperty("Boolean (Y/N) - Is Partial Processing of Cession Batch Allowed. Used only if Type of Business Proportional Assumed Business.")
    @TableField("ALLOW_PARTIALPROC_CESS_BAT")
    private String allowPartialprocCessBat;

    @ApiModelProperty("Boolean (Y/N) - Automatically Booked Figures On OCC ORP")
    @TableField("AUTO_BOOK_OCC")
    private String autoBookOcc;

    @ApiModelProperty("Account Group. Reference data subclass number. Expected values NULL or 225")
    @TableField("FSK_ACCOUNT_GROUP")
    private Integer fskAccountGroup;

    @ApiModelProperty("Indicates which application the row belongs to. SICS System. Reference data subclass number. Expected values NULL or 159")
    @TableField("FSK_SICSNT_SYSTEM")
    private Integer fskSicsntSystem;

    @ApiModelProperty("Type Of Business. Type Of Business. Reference data subclass number. Expected values NULL or 46")
    @TableField("FSK_TYPE_OF_BUS")
    private Integer fskTypeOfBus;

    @ApiModelProperty("Level Of Business. Level Of Business. Reference data subclass number. Expected values NULL or 45")
    @TableField("FSK_LEVEL_OF_BUS")
    private Integer fskLevelOfBus;

    @ApiModelProperty("Life Specific. Indicates Trad, Trad-Fin, or Fin Re business. Reference data subclass number. Defines the reference data table for the code value in FRK_NATURE_OF_BUS")
    @TableField("FSK_NATURE_OF_BUS")
    private Integer fskNatureOfBus;

    @ApiModelProperty("Functional Currency. Foreign key to: CNU_CURRENCY : SicsCurrency")
    @TableField("FK_FUNCTIONAL_CCY")
    private String fkFunctionalCcy;

    @ApiModelProperty("Functional Currency 2. Foreign key to: CNU_CURRENCY : SicsCurrency")
    @TableField("FK_FUNCTIONAL_CCY2")
    private String fkFunctionalCcy2;

    @ApiModelProperty("Indicates which Access Code is assigned to this row. Access Code. Reference data subclass number. Expected values NULL or 260")
    @TableField("FSK_ACCESS_CODE")
    private Integer fskAccessCode;

    @ApiModelProperty("Primary System. Used for Ceded to Store the External System the Policy is Imported from. External System Name. Reference data subclass number. Expected values NULL or 1074")
    @TableField("FSK_PRIM_SYSTEM")
    private Integer fskPrimSystem;

    @ApiModelProperty("The reason for cease accounting. Business Cease Accounting Description. Reference data subclass number. Expected values NULL or 1076")
    @TableField("FSK_CEASE_ACC_DESC")
    private Integer fskCeaseAccDesc;

    @ApiModelProperty("Foreign Key to SicsRefAccountingReviewType. Accounting Review Type. Reference data subclass number. Expected values NULL or 1150")
    @TableField("FSK_ACC_REV_TYPE")
    private Integer fskAccRevType;

    @ApiModelProperty("Exchange rate category for premium. Accounting Exchange Rate Category. Reference data subclass number. Expected values NULL or 1116")
    @TableField("FSK_EXCH_CTGRY_P")
    private Integer fskExchCtgryP;

    @ApiModelProperty("Exchange rate category for claim. Accounting Exchange Rate Category. Reference data subclass number. Expected values NULL or 1116")
    @TableField("FSK_EXCH_CTGRY_C")
    private Integer fskExchCtgryC;

    @ApiModelProperty("Legal Language. Reference data subclass number. Expected values NULL or 2024")
    @TableField("FSK_LANGUAGE")
    private Integer fskLanguage;

    @ApiModelProperty("Internal. Used to identify subtypes of: SicsBusiness")
    @TableField("SUBCLASS")
    private Integer subclass;

    @ApiModelProperty("Internal. Used for write locking mechanism.")
    @TableField("VERSION")
    private Integer version;

    @ApiModelProperty("Title of the Business.")
    @TableField("TITLE")
    private String title;

    @ApiModelProperty("Uppercase Title of Business.")
    @TableField("UPPERCASE_TITLE")
    private String uppercaseTitle;

    @ApiModelProperty("Identifier of the Business.")
    @TableField("IDENTIFIER")
    private String identifier;

    @ApiModelProperty("Prefix of the identifier of the Business.")
    @TableField("ID_PREFIX")
    private String idPrefix;

    @ApiModelProperty("Former Identifier of the Business.")
    @TableField("FORMER_IDENTIFIER")
    private String formerIdentifier;

    @ApiModelProperty("The identifier in an external system.")
    @TableField("EXT_IDENTIFIER")
    private String extIdentifier;

    @ApiModelProperty("The name in an external system.")
    @TableField("EXT_NAME")
    private String extName;

    @ApiModelProperty("Full Name for field ")
    @TableField("SHORT_NAME")
    private String shortName;

    @ApiModelProperty("Account Group. Code value from reference data table number 225")
    @TableField("FRK_ACCOUNT_GROUP")
    private String frkAccountGroup;

    @ApiModelProperty("Foreign key to: CNU_NOTE : CnuNote")
    @TableField("FK_NOTE")
    private String fkNote;

    @ApiModelProperty("Indicates which application the row belongs to. SICS System. Code value from reference data table number 159")
    @TableField("FRK_SICSNT_SYSTEM")
    private String frkSicsntSystem;

    @ApiModelProperty("Type Of Business. Type Of Business. Code value from reference data table number 46")
    @TableField("FRK_TYPE_OF_BUS")
    private String frkTypeOfBus;

    @ApiModelProperty("Level Of Business. Level Of Business. Code value from reference data table number 45")
    @TableField("FRK_LEVEL_OF_BUS")
    private String frkLevelOfBus;

    @ApiModelProperty("Life Specific. Indicates Trad, Trad-Fin, or Fin Re business. Code value from reference data table number specified in FSK_NATURE_OF_BUS")
    @TableField("FRK_NATURE_OF_BUS")
    private String frkNatureOfBus;

    @ApiModelProperty("Foreign key to SicsBusinessPartnerRelationship.  Cedent Relationship. Foreign key to: BUSINESS_PRTNR_REL : SicsBusinessPartnerRelationship")
    @TableField("FK_CEDENT_REL")
    private String fkCedentRel;

    @ApiModelProperty("Original Cedent Relationship. Foreign key to: BUSINESS_PRTNR_REL : SicsBusinessPartnerRelationship")
    @TableField("FK_ORG_CDNT_RL")
    private String fkOrgCdntRl;

    @ApiModelProperty("This column is not in use, and may be removed in a future release. Foreign key to: BUSINESS_PRTNR_REL : SicsBusinessPartnerRelationship")
    @TableField("FK_CO_ADMN_REL")
    private String fkCoAdmnRel;

    @ApiModelProperty("Insured Relationship. Foreign key to: BUSINESS_PRTNR_REL : SicsBusinessPartnerRelationship")
    @TableField("FK_INSURED_REL")
    private String fkInsuredRel;

    @ApiModelProperty("Merger Group. Foreign key to: BUS_GROUP : SicsGroup")
    @TableField("FK_MERGER_GRP")
    private String fkMergerGrp;

    @ApiModelProperty("Indicates which Access Code is assigned to this row. Access Code. Code value from reference data table number 260")
    @TableField("FRK_ACCESS_CODE")
    private String frkAccessCode;

    @ApiModelProperty("Foreign key to the Business Master Treaty Group. Foreign key to: BUS_GROUP : SicsGroup")
    @TableField("FK_MST_TREATY_GRP")
    private String fkMstTreatyGrp;

    @ApiModelProperty("Foreign key to the Business Risk Unit Group. Foreign key to: BUS_GROUP : SicsGroup")
    @TableField("FK_RISK_UNIT_GRP")
    private String fkRiskUnitGrp;

    @ApiModelProperty("Primary System. Used for Ceded to Store the External System the Policy is Imported from. External System Name. Code value from reference data table number 1074")
    @TableField("FRK_PRIM_SYSTEM")
    private String frkPrimSystem;

    @ApiModelProperty("The reason for cease accounting. Business Cease Accounting Description. Code value from reference data table number 1076")
    @TableField("FRK_CEASE_ACC_DESC")
    private String frkCeaseAccDesc;

    @ApiModelProperty("Foreign key to the Light Policy Business. Foreign key to: LIGHT_POLICY : SicsPolicyLightBusiness")
    @TableField("FK_LIGHT_BUSINESS")
    private String fkLightBusiness;

    @ApiModelProperty("Business Stamp. Foreign key to: BUS_STAMP : SicsBusinessStamp")
    @TableField("FK_STAMP")
    private String fkStamp;

    @ApiModelProperty("Foreign Key to SicsRefAccountingReviewType. Accounting Review Type. Code value from reference data table number 1150")
    @TableField("FRK_ACC_REV_TYPE")
    private String frkAccRevType;

    @ApiModelProperty("Exchange rate category for premium. Accounting Exchange Rate Category. Code value from reference data table number 1116")
    @TableField("FRK_EXCH_CTGRY_P")
    private String frkExchCtgryP;

    @ApiModelProperty("Exchange rate category for claim. Accounting Exchange Rate Category. Code value from reference data table number 1116")
    @TableField("FRK_EXCH_CTGRY_C")
    private String frkExchCtgryC;

    @ApiModelProperty("Legal Language. Code value from reference data table number 2024")
    @TableField("FRK_LANGUAGE")
    private String frkLanguage;


}
