import static com.ninja_squad.dbsetup.Operations.*;
import com.ninja_squad.dbsetup.operation.Operation;

public class DBSetupCommonOperations {
	public static final Operation settleConfigAcquirerAcquirerTestCase =
 	sequenceOf(
	deleteAllFrom("SETTLE_ACQUIRERS","SETTLE_CONTRACTS","SETTLE_SETTLEMENT_PARAMETERS","SETTLE_SESSIONS","SETTLE_OPERATION_DETAILS","SETTLE_OPERATIONS","SETTLE_SETTLEMENT_MOVEMENTS"),
	insertInto("SETTLE_ACQUIRERS")
	.columns("ID_ACQUIRER","ACQ_SYS_ALIAS","ACQ_COMMENT")
	.values("00","CTC0","ctc merchant")
	.values("01","CTC1","ctc1 atos")
	.values("10","FEXCO","Fexco")
	.values("87","INDIA","AWL India")
	.build());

	public static final Operation settleConfigSettlementparamContractQueriesTestCase =
 	sequenceOf(
	deleteAllFrom("SETTLE_ACQUIRERS","SETTLE_CONTRACTS","SETTLE_SETTLEMENT_PARAMETERS","SETTLE_SESSIONS","SETTLE_OPERATIONS","SETTLE_SETTLEMENT_MOVEMENTS","SETTLE_OPERATION_DETAILS"),
	insertInto("SETTLE_ACQUIRERS")
	.columns("ID_ACQUIRER","ACQ_SYS_ALIAS","ACQ_COMMENT")
	.values("00","CTC0","ctc merchant")
	.values("01","CTC1","ctc1 atos")
	.values("02","CTC2","experian")
	.values("10","FEXCO","Fexco")
	.values("87","INDIA","AWL India")
	.values("PA","PAYON","online payon")
	.values("33","COFIDIS","cofidis")
	.build(),
	insertInto("SETTLE_CONTRACTS")
	.columns("ID_CONTRACT","NETWORK_ALIAS","techno","MERCHANT_TYPE","MERCHANT_PROFILE","CARD_NETWORK","CAPTURE_ALIAS","ID_ACQUIRER")
	.values("id1","CB","NO","SIPS","1D","CB","CAPTURE_SIPS","01")
	.values("id2","CB","NO","SIPS","1D","CB","CAPTURE_SIPS","01")
	.values("id3","CB","NO","SIPS","1D","CB","CAPTURE_SIPS","02")
	.values("id11","CB","DCC")
	.values("id4","CB","NO","SIPS","1D","INDIA","NO","87")
	.values("id5","INDIA","NO","SIPS","1D","INDIA","NO","87")
	.values("id6","AMEX","NO","SIPS","1D","INDIA","NO","87")
	.values("id7","AMEX","NO","SIPS","1D","INDIA","NO","87")
	.values("id8","PAYON","NO","SIPS","1D","PAYON","NO","PA")
	.values("id9","PAYON","NO","SIPS","1D","PAYON","NO","PA")
	.values("id10","PAYON","NO","SIPS","1D","PAYON","NO","PA")
	.values("id12","COFIDIS","NO","SIPS","1D","COFIDIS","CAPTURE_FRA","33")
	.build(),
	insertInto("SETTLE_SETTLEMENT_PARAMETERS")
	.columns("ID_SETTLEPARM","NETWORK_ALIAS","TECHNO")
	.values("id1","CB","NO")
	.values("id2","CB","NO")
	.values("id11","CB","DCC")
	.build());

	public static final Operation settleConfigSettlementparamSettlementParameterQueriesTestCase =
 	sequenceOf(
	deleteAllFrom("SETTLE_CONTRACTS","SETTLE_SETTLEMENT_PARAMETERS"),
	insertInto("SETTLE_CONTRACTS")
	.columns("ID_CONTRACT","NETWORK_ALIAS","TECHNO")
	.values("id1","CB","NO")
	.values("id2","CB","NO")
	.values("id11","CB","DCC")
	.build(),
	insertInto("SETTLE_SETTLEMENT_PARAMETERS")
	.columns("ID_SETTLEPARM","NETWORK_ALIAS","TECHNO","SERVICE_ID","CTCDEST","CAPTURE_ALIAS","REMIT_FORMAT")
	.values("id1","CB","NO","SIPS","CTC1","CAPTURE_SIPS","CB2A")
	.values("id2","CB","NO","SIPS","CTC1","CAPTURE_SIPS","CB2A")
	.values("id11","CB","DCC")
	.values("id3","CB","NO","SIPS","CTC2","CAPTURE_SIPS","CB")
	.values("id4","INDIA","NO","ALL","INDIA","NO","INDIA")
	.values("id5","INDIA","NO","ALL","INDIA","NO","INDIA")
	.values("id6","AMEX","NO","ALL","INDIA","NO","INDIA")
	.build());

	public static final Operation settleConfigSettlementparamSettlementParamLifeCycleTestCase =
 	sequenceOf(
	deleteAllFrom("SETTLE_CONTRACTS","SETTLE_SETTLEMENT_PARAMETERS"),
	insertInto("SETTLE_CONTRACTS")
	.columns("ID_CONTRACT","NETWORK_ALIAS","TECHNO")
	.values("id1","CB","NO")
	.values("id2","CB","NO")
	.values("id11","CB","DCC")
	.build(),
	insertInto("SETTLE_SETTLEMENT_PARAMETERS")
	.columns("ID_SETTLEPARM","NETWORK_ALIAS","TECHNO")
	.values("id1","CB","NO")
	.values("id2","CB","NO")
	.values("id11","CB","DCC")
	.build());

	public static final Operation settleCoreConciliationConciliationManager =
 	sequenceOf(
	deleteAllFrom("SETTLE_SESSIONS","SETTLE_OPERATION_DETAILS","SETTLE_SETTLEMENT_FILES","SETTLE_OPERATIONS","SETTLE_SETTLEMENT_MOVEMENTS"),
	insertInto("SETTLE_SESSIONS")
	.columns("ID_SESSION","AIID","AUTHORIZATION_NB_OPERATIONS","AUTHORIZATION_TOTAL_AMOUNT","FULL_CANCEL_NB_OPERATIONS","FULL_CANCEL_TOTAL_AMOUNT","FULL_REFUND_NB_OPERATIONS","FULL_REFUND_TOTAL_AMOUNT","PARTIAL_CANCEL_NB_OPERATIONS","PARTIAL_CANCEL_TOTAL_AMOUNT","PARTIAL_REFUND_NB_OPERATIONS","PARTIAL_REFUND_TOTAL_AMOUNT","SESSION_DATE","SESSION_NUMBER","STATUS","ACQUIRER_ID")
	.values("SID_BEING1","aiid","1","100","2","200","3","300","4","400","5","500","2012-07-26 14:05:00","1","BEING_CLOSED","00")
	.build(),
	insertInto("SETTLE_OPERATION_DETAILS")
	.columns("ID_OPER_DETAIL","ACCEPTOR_ID","AMOUNT_ISOCODE","AMOUNT_VALUE","AUTHORIZATION_CODE","CARD_TYPE","CIPHER_CARD_NUMBER","DATE_NUM","DATE_TIME_TRANSACTION","MERCHANT_BANK_CODE","MESSAGE_TYPE","ORIGIN_AMOUNT_ISOCODE","ORIGIN_AMOUNT_VALUE","ORIGINAL_OPER_TRANSACTION_DATE","ORIGINAL_OPER_MESSAGE_TYPE","ORIGINAL_OPER_TRANSACTION_ID","STAN","TRANSACTION_ID","ID_SESSION")
	.values("1","cept","EUR","200","01","02","123456789XYZ","20060601","2012-07-26 15:05:00","12","AUTHORIZATION","EUR","100","2012-07-26 14:05:00","DUAL","txId10","stan0","txId10","SID_BEING1")
	.build());

	public static final Operation settleCoreReferencesReferenceTableQueriesTest =
 	sequenceOf(
	deleteAllFrom("SETTLE_TRANSACTION_STATUSES","SETTLE_CARD_TYPES","SETTLE_ACCEPTOR_TYPE_ALIAS","SETTLE_NETWORK_ALIAS"),
	insertInto("SETTLE_TRANSACTION_STATUSES")
	.columns("ID_TRAN_STATUS","TRAN_STATUS","TRAN_STATUS_ALIAS")
	.values("00","AB","ABORTED")
	.values("01","CA","CANCELLED")
	.values("02","CD","CREDIT_REFUSED")
	.values("03","CF","CAPTURE_REFUSED")
	.values("04","CP","CAPTURED")
	.values("05","CR","CREDITED")
	.values("06","EN","ENDED")
	.values("07","ER","ERROR")
	.values("08","EX","EXPIRED")
	.values("09","IN","INIT")
	.values("10","NO","REFUSED")
	.values("11","RE","REFERRAL")
	.values("12","TA","TO_AUTHORIZE")
	.values("13","TC","TO_CREDIT")
	.values("14","TH","TO_CONFIRM_AUTH")
	.values("15","TN","TO_CONFIRM_CAPT")
	.values("16","TP","TO_CAPTURE")
	.values("17","TR","TO_REPLAY")
	.values("18","TT","TO_CONFIRM_CREDIT")
	.values("19","TV","TO_VALIDATE")
	.values("20","UN","UNDEFINED")
	.values("21","WA","WAITING_AUTHOR")
	.values("22","WC","WAITING_CAPTURE")
	.values("23","WO","WAITING_OPPOTOTA")
	.build(),
	insertInto("SETTLE_CARD_TYPES")
	.columns("ID_CARD_TYPE","BRAND_ID","CARD_TYPE")
	.values("00","0","UNKNOWN")
	.values("01","01","CB")
	.values("02","02","VISA")
	.values("03","04","MASTERCARD")
	.values("04","05","VISA_PURCH")
	.values("05","06","MAESTRO")
	.values("06","07","VPAY")
	.values("07","08","AMEX")
	.values("08","16","DINERS")
	.values("09","20","FINAREF")
	.values("10","21","NXCB")
	.values("11","22","AURORE")
	.values("12","23","NXCB_PREL")
	.values("13","24","VOYAGEUR")
	.values("14","25","PASS2")
	.values("15","26","CBPASS")
	.values("16","28","JCB")
	.values("17","29","PRESTO")
	.values("18","30","NETRESERVE")
	.values("19","31","3XCBCOFINOGA")
	.values("20","32","PEUGEOT")
	.values("21","33","1EUROCOM")
	.values("22","34","4ETOILES")
	.values("23","35","CREDIT_CTLM")
	.values("24","36","DELTA")
	.values("25","37","PLURIEL")
	.values("26","38","COFINOGA")
	.values("27","39","CBCOFINOGA")
	.values("28","41","ELV")
	.values("29","42","AURORE_OFFER")
	.values("30","43","CONFORAMA")
	.values("31","44","NUITEA")
	.values("32","45","PASS")
	.values("33","46","PASS3FOIS")
	.values("34","47","CTLM_BYTEL")
	.values("35","48","AURORE_BRAND")
	.values("36","49","AURORE_ID")
	.values("37","50","POCKETCARD")
	.values("38","51","FNACCARD")
	.values("39","52","KANGOUROU")
	.values("40","53","FNAC")
	.values("41","54","CYRILLUS")
	.values("42","55","PRINTEMPS")
	.values("43","56","SURCOUF")
	.values("44","57","CONFORAMA2")
	.values("45","58","CLUBMED")
	.values("46","5R","GOSPORT_COMPTE")
	.values("47","5S","OKSHOPPING_COMPTE")
	.values("48","5T","CLUBMED_COMPTE")
	.values("49","5U","MANDARINE_COMPTE")
	.values("50","5V","SURCOUF_COMPTE")
	.values("51","5W","PRINTEMPS_COMPTE")
	.values("52","5X","KANGOUROU_COMPTE")
	.values("53","5Y","FNAC_COMPTE")
	.values("54","5Z","FINAREF_COMPTE")
	.values("55","60","SWITCH")
	.values("56","61","SOLO")
	.values("57","63","BANCONTACTMISTERCASH")
	.values("58","64","AIRPLUS")
	.values("59","65","INTL_DDEBIT")
	.values("60","66","SCT")
	.values("61","67","AMEX_LOGEE")
	.values("62","69","PAYPAL")
	.values("63","70","BANK_CHEQUE")
	.values("64","71","POST_CHEQUE")
	.values("65","72","ACCORD")
	.values("66","73","ACCORD_KDO")
	.values("67","74","ACCORD_OFP")
	.values("68","75","OBOPAY_P2M")
	.values("69","76","OBOPAY_P2P")
	.values("70","77","OBOPAY_T2B")
	.values("71","78","WEXPAY")
	.values("72","79","IDEAL")
	.values("73","80","PROMONETIC")
	.values("74","81","COFIDIS_3X")
	.values("75","82","PROFILPLUS")
	.values("76","83","LIBRAVOU")
	.values("77","84","PAIEMENT_COFIDIS")
	.values("78","85","CUP")
	.values("79","86","BUYSTER")
	.values("80","87","MINITIX")
	.values("81","88","BCACUP")
	.values("82","89","BUYBOX")
	.values("83","90","ACCORD_3X")
	.values("84","91","ACCORD_4X")
	.values("85","92","PASSBE")
	.values("86","93","NETBANKING")
	.values("87","95","SEPA_DIRECT_DEBIT")
	.values("88","96","SOFORTUBERWEISUNG")
	.build(),
	insertInto("SETTLE_ACCEPTOR_TYPE_ALIAS")
	.columns("ID_ACCEPTOR_TYPE","ACCEPTOR_TYPE","ACCEPTOR_TYPE_ALIAS")
	.values("00","0","OTHER")
	.values("01","1","CARD")
	.values("02","2","CYBERCOMM")
	.values("03","3","SET")
	.values("04","4","SET2KP")
	.values("05","5","MOSET")
	.values("06","6","GSM")
	.values("07","7","CHEQUE")
	.values("08","8","PREPAID")
	.values("09","9","CREDIT_TRANSFER")
	.values("10","A","DCC")
	.values("11","B","DIRECT_DEBIT")
	.build(),
	insertInto("SETTLE_NETWORK_ALIAS")
	.columns("ID_NETWORK","NETWORK_ID","NETWORK_ALIAS")
	.values("00","00","UNKNOWN")
	.values("01","01","CB")
	.values("02","02","CB")
	.values("03","08","AMEX")
	.values("04","16","DINERS")
	.values("05","20","FINAREF")
	.values("06","22","CETELEM")
	.values("07","24","SNCF")
	.values("08","25","S2P")
	.values("09","28","JCB")
	.values("10","32","CREDIPAR")
	.values("11","33","COFIDIS")
	.values("12","34","PFCA")
	.values("13","36","NATWEST")
	.values("14","37","FRANFINANCE")
	.values("15","38","COFINOGA")
	.values("16","40","BANK")
	.values("17","41","ELV")
	.values("18","50","PROMONETIC")
	.values("19","63","BANKSYS")
	.values("20","64","LOGEES")
	.values("21","66","CT_TRANSFER")
	.values("22","69","PAYPAL")
	.values("23","70","ACCORD")
	.values("24","72","CT6")
	.values("25","76","WEXPAY")
	.values("26","77","IDEAL")
	.values("27","85","CUP")
	.values("28","86","BUYSTER")
	.values("29","87","MINITIX")
	.values("30","88","BCACUP")
	.values("31","89","BUYBOX")
	.values("32","90","INDIA")
	.values("33","91","NETBANKING")
	.values("34","93","BUYWAY")
	.values("35","94","OGONE")
	.values("36","95","SEPA_DIRECT_DEBIT")
	.values("37","96","SOFORT")
	.build());

	public static final Operation settleCoreSettlementSettlementFileQueriesTestCase =
 	sequenceOf(
	deleteAllFrom("SETTLE_SETTLEMENT_FILES","SETTLE_OPERATIONS","SETTLE_SETTLEMENT_MOVEMENTS"),
	insertInto("SETTLE_SETTLEMENT_FILES")
	.columns("ID_SETTLEFILE","ACQ_SYS_ALIAS","FILE_ALIAS","MERCHANT_PROFILE","NETWORK_ALIAS","OFFER","TECHNO","NO_OF_SETTLE_MOVEMENT","STATUS","END_DATE_TIME","EXECUTION_MODE","SESSION_ID")
	.values("1000","CTC1","CAPTURE_SIPS","1D","CB","SIPS","SSL","0","FILE_CREATED","PRODUCTION")
	.values("1001","CTC2","CAPTURE_SIPS","1D","CB","SIPS","SSL","0","ENDED","2012-07-08 15:05:00","PRODUCTION")
	.values("1002","CTC3","CAPTURE_SIPS","1D","CB","SIPS","SSL","3","ENDED","2012-07-08 15:05:00","PRODUCTION")
	.values("1003","CTC2","PAYON","3","FILE_CREATED","2012-07-08 15:05:00","PRODUCTION","S_1")
	.build());

	public static final Operation settleCoreSettlementSettlementMovementQueriesTestCase =
 	sequenceOf(
	deleteAllFrom("SETTLE_SETTLEMENT_FILES","SETTLE_OPERATIONS","SETTLE_SETTLEMENT_MOVEMENTS"),
	insertInto("SETTLE_SETTLEMENT_FILES")
	.columns("ID_SETTLEFILE","ACQ_SYS_ALIAS","FILE_ALIAS","MERCHANT_PROFILE","NETWORK_ALIAS","OFFER","TECHNO","NO_OF_SETTLE_MOVEMENT","STATUS","EXECUTION_MODE")
	.values("1000","CTC1","CAPTURE_SIPS","1D","CB","SIPS","SSL","0","FILE_CREATED","PRODUCTION")
	.values("1001","CTC1","CAPTURE_SIPS","1D","CB","SIPS","SSL","0","FILE_CREATED","PRODUCTION")
	.values("1002","CTC1","CAPTURE_SIPS","1D","CB","SIPS","SSL","0","FILE_CREATED","PRODUCTION")
	.values("1003","CTC1","CAPTURE_SIPS","1D","CB","SIPS","SSL","0","FILE_CREATED","PRODUCTION")
	.build(),
	insertInto("SETTLE_OPERATIONS")
	.columns("ID_OPERATION","TRANSACTION_ID","MERCHANT_ID","MERCHANT_COUNTRY","NETWORK_ALIAS","NETWORK_ID","STATUS","AUTHOR_COUNT","CASH_AMOUNT_VALUE","CONSUMER_CREDITAMOUNT_VALUE","OPER_AMOUNT_VALUE","OVERTAKE_AMOUNT_VALUE","CVV_FLAG","ORIGIN_AMOUNT_VALUE","PAYMENT_NB","KEY_SIPS","DUEDATE_NUM","ITEM_OPERATION","REFITEM_OPERATION","PAYMENT_SEQ","CURRENT_TRANSAMOUNT_VALUE","dateNum","CAPTURE_LIMIT_DATE","ACCEPTOR_TYPE_ALIAS","OPP_REF")
	.values("1","txId1","merchantId1","FR","CB","02","TO_CAPTURE","0","0","0","0","0","0","0","0","0","0","0","0","0","100","20060601","2012-07-29 15:05:03","SSL","opp")
	.values("2","txId1","merchantId1","FR","CB","02","TO_CAPTURE","0","0","0","0","0","0","0","0","0","0","0","0","0","100","20060601","2012-07-29 15:05:03","SSL","opp")
	.values("3","txId1","merchantId1","FR","CB","02","TO_CAPTURE","0","0","0","0","0","0","0","0","0","0","0","0","0","100","20060601","2012-07-29 15:05:03","SSL","opp")
	.values("4","txId1","merchantId1","FR","CB","02","TO_CAPTURE","0","0","0","0","0","0","0","0","0","0","0","0","0","100","20060601","2012-07-29 15:05:03","SSL","opp")
	.values("5","txId1","merchantId1","FR","CB","02","TO_CAPTURE","0","0","0","0","0","0","0","0","0","0","0","0","0","100","20060601","2012-07-29 15:05:03","SSL","opp")
	.values("6","txId1","merchantId1","FR","CB","02","TO_CAPTURE","0","0","0","0","0","0","0","0","0","0","0","0","0","100","20060601","2012-07-29 15:05:03","SSL","opp")
	.build(),
	insertInto("SETTLE_SETTLEMENT_MOVEMENTS")
	.columns("ID_SETTLEMVT","SETTLEMENT_STATUS","ID_SETTLEFILE","ID_OPERATION")
	.values("1","TO_SETTLE","1000","1")
	.values("2","TO_SETTLE","1000","2")
	.values("3","TO_SETTLE","1000","3")
	.values("4","TO_SETTLE","1001","4")
	.values("5","TO_SETTLE","1002","5")
	.values("6","TO_SETTLE","1003","6")
	.build());

	public static final Operation settleCoreSettlementmanagementSettlementManagerTestCase =
 	sequenceOf(
	deleteAllFrom("SETTLE_SETTLEMENT_FILES","SETTLE_SESSIONS","SETTLE_OPERATIONS","SETTLE_SETTLEMENT_MOVEMENTS","SETTLE_OPERATION_DETAILS"),
	insertInto("SETTLE_SETTLEMENT_FILES")
	.columns("ID_SETTLEFILE","ACQ_SYS_ALIAS","FILE_ALIAS","MERCHANT_PROFILE","NETWORK_ALIAS","OFFER","TECHNO","NO_OF_SETTLE_MOVEMENT","STATUS","EXECUTION_MODE")
	.values("100","CTC1","CAPTURE_SIPS","1D","CB","SIPS","SSL","0","FILE_CREATED","PRODUCTION")
	.values("101","CTC2","CAPTURE_SIPS","1D","CB","SIPS","SSL","0","FILE_CREATED","PRODUCTION")
	.values("102","CTC3","CAPTURE_SIPS","1D","CB","SIPS","SSL","0","FILE_CREATED","PRODUCTION")
	.values("103","0","STARTED","PRODUCTION")
	.values("104","0","STARTED","PRODUCTION")
	.build(),
	insertInto("SETTLE_SESSIONS")
	.columns("ID_SESSION","AIID","AUTHORIZATION_NB_OPERATIONS","AUTHORIZATION_TOTAL_AMOUNT","FULL_CANCEL_NB_OPERATIONS","FULL_CANCEL_TOTAL_AMOUNT","FULL_REFUND_NB_OPERATIONS","FULL_REFUND_TOTAL_AMOUNT","PARTIAL_CANCEL_NB_OPERATIONS","PARTIAL_CANCEL_TOTAL_AMOUNT","PARTIAL_REFUND_NB_OPERATIONS","PARTIAL_REFUND_TOTAL_AMOUNT","SESSION_DATE","SESSION_NUMBER","STATUS","ACQUIRER_ID")
	.values("SID_01","aiid","1","100","2","200","3","300","4","400","5","500","2012-07-26 14:05:00","1","OPENED","00")
	.values("SID_02","aiid","1","100","2","200","3","300","4","400","5","500","2012-07-26 14:05:00","1","CLOSED","00")
	.build(),
	insertInto("SETTLE_OPERATIONS")
	.columns("ID_OPERATION","TRANSACTION_ID","MERCHANT_ID","MERCHANT_COUNTRY","NETWORK_ALIAS","NETWORK_ID","STATUS","AUTHOR_COUNT","CASH_AMOUNT_VALUE","CONSUMER_CREDITAMOUNT_VALUE","OPER_AMOUNT_VALUE","OVERTAKE_AMOUNT_VALUE","CVV_FLAG","ORIGIN_AMOUNT_VALUE","PAYMENT_NB","ACCEPTOR_TYPE_ALIAS","CURRENT_TRANSAMOUNT_VALUE","KEY_SIPS","DUEDATE_NUM","ITEM_OPERATION","REFITEM_OPERATION","PAYMENT_SEQ","OPP_REF","CIPHER_CARD_NUM","CAPTURE_LIMIT_DATE","ID_SESSION")
	.values("9000","txId1","merchantId1","FR","CTC","02","TO_CAPTURE","10","10","10","0","0","0","0","100","typeAlias","100","0","0","0","0","0","opp","756EA32CF8CD4A02","2012-07-29 15:05:03")
	.values("9001","txId2","merchantId2","FR","CTC","02","TO_CAPTURE","10","10","10","0","0","0","0","100","typeAlias","100","0","0","0","0","0","opp","756EA32CF8CD4A02","2012-07-29 15:05:03")
	.values("9002","txId3","merchantId3","FR","CTC","02","TO_CAPTURE","10","10","10","0","0","0","0","100","typeAlias","100","0","0","0","0","0","opp","756EA32CF8CD4A02","2012-07-29 15:05:03")
	.values("9003","txId4","merchantId4","FR","CTC","02","TO_CAPTURE","10","10","10","0","0","0","0","100","typeAlias","100","0","0","0","0","0","opp","756EA32CF8CD4A02","2012-07-29 15:05:03")
	.values("9004","txId4","merchantId5","FR","CTC","02","TO_CAPTURE","10","10","10","0","0","0","0","100","typeAlias","100","0","0","0","0","0","opp","","2012-07-29 15:05:03")
	.values("9005","txId5","merchantId5","FR","CTC","02","TO_CAPTURE","10","10","10","0","0","0","0","100","typeAlias","100","0","0","0","0","0","opp","756EA32CF8CD4A02","2012-07-29 15:05:03")
	.values("9006","txId6","merchantId6","FR","CTC","02","TO_CAPTURE","10","10","10","0","0","0","0","100","typeAlias","100","0","0","0","0","0","opp","","2012-07-29 15:05:03")
	.values("9007","txId7","merchantId7","FR","CTC","02","TO_CAPTURE","10","10","10","0","0","0","0","100","typeAlias","100","0","0","0","0","0","opp","123456","2012-07-29 15:05:03")
	.values("9008","txId1","merchantId8","FR","CTC","02","TO_CAPTURE","10","10","10","0","0","0","0","100","typeAlias","100","0","0","0","0","0","opp","756EA32CF8CD4A02","2012-07-29 15:05:03")
	.values("9009","txId1","merchantId8","FR","CTC","02","TO_CAPTURE","10","10","10","0","0","0","0","100","typeAlias","100","0","0","0","0","0","opp","756EA32CF8CD4A02","2012-07-29 15:05:03","SID_01")
	.values("9010","txId1","merchantId8","FR","CTC","02","TO_CAPTURE","10","10","10","0","0","0","0","100","typeAlias","100","0","0","0","0","0","opp","756EA32CF8CD4A02","2012-07-29 15:05:03","SID_02")
	.build(),
	insertInto("SETTLE_SETTLEMENT_MOVEMENTS")
	.columns("ID_SETTLEMVT","SETTLEMENT_STATUS","ID_OPERATION")
	.values("1001","TO_SETTLE","9000")
	.values("1002","TO_SETTLE","9001")
	.values("1003","SETTLE_OK","9002")
	.values("1004","SETTLE_OK","9003")
	.values("1005","TO_SETTLE","9004")
	.values("1006","TO_SETTLE","9005")
	.values("1007","TO_SETTLE","9006")
	.values("1008","TO_SETTLE","9007")
	.values("1009","TO_SETTLE","9008")
	.values("1010","TO_SETTLE","9009")
	.values("1011","TO_SETTLE","9010")
	.build());

	public static final Operation settleCoreTemptablemanagementCleanTempTable =
 	sequenceOf(
	deleteAllFrom("SETTLE_SESSIONS","SETTLE_OPERATION_DETAILS","SETTLE_OPERATIONS_TEMP0","SETTLE_OPERATIONS_TEMP1","SETTLE_OPERATIONS_TEMP2","SETTLE_OPERATIONS_TEMP3","SETTLE_OPERATIONS_TEMP4","SETTLE_OPERATIONS_TEMP5","SETTLE_OPERATIONS_TEMP6","SETTLE_OPERATIONS","SETTLE_SETTLEMENT_FILES","SETTLE_SETTLEMENT_MOVEMENTS"),
	insertInto("SETTLE_OPERATIONS")
	.columns("ID_OPERATION","TRANSACTION_ID","MERCHANT_ID","MERCHANT_COUNTRY","NETWORK_ALIAS","NETWORK_ID","STATUS","AUTHOR_COUNT","CASH_AMOUNT_VALUE","CONSUMER_CREDITAMOUNT_VALUE","OPER_AMOUNT_VALUE","OVERTAKE_AMOUNT_VALUE","CVV_FLAG","ORIGIN_AMOUNT_VALUE","PAYMENT_NB","KEY_SIPS","DUEDATE_NUM","ITEM_OPERATION","REFITEM_OPERATION","PAYMENT_SEQ","CURRENT_TRANSAMOUNT_VALUE","dateNum","CAPTURE_LIMIT_DATE","OPP_REF","ID_SESSION","CURRENT_TRANSAMOUNT_ISOCODE","ACCEPTOR_TYPE_ALIAS")
	.values("1","txId1","merchantId1","FR","CB","02","TO_CAPTURE","0","0","0","0","0","0","0","0","0","0","0","0","0","100","20060601","2012-07-26 15:05:00","opp","978","Card")
	.values("2","txId2","merchantId1","FR","CB","02","TO_CAPTURE","0","0","0","0","0","0","0","0","0","0","0","0","0","100","20060601","2012-07-26 15:05:00","opp","978","Card")
	.values("3","txId1","merchantId2","FR","CB","02","TO_CAPTURE","0","0","0","0","0","0","0","0","0","0","0","0","0","100","20060601","2012-07-26 15:05:00","opp","978","Card")
	.values("4","txId2","merchantId2","FR","CB","02","TO_CAPTURE","0","0","0","0","0","0","0","0","0","0","0","0","0","100","20060601","2012-07-26 15:05:00","opp","978","Card")
	.values("5","txId1","merchantId3","FR","CB","02","TO_CAPTURE","0","0","0","0","0","0","0","0","0","0","0","0","0","100","20060601","2012-07-26 15:05:00","opp","978","Card")
	.values("6","txId2","merchantId3","FR","CB","02","TO_CAPTURE","0","0","0","0","0","0","0","0","0","0","0","0","0","100","20060601","2012-07-26 15:05:00","opp","978","Card")
	.values("7","txId1","merchantId4","FR","CB","02","TO_CAPTURE","0","0","0","0","0","0","0","0","0","0","0","0","0","100","20060601","2012-07-26 15:05:00","opp","978","Card")
	.values("8","txId2","merchantId4","FR","CB","02","TO_CAPTURE","0","0","0","0","0","0","0","0","0","0","0","0","0","100","20060601","2012-07-26 15:05:00","opp","978","Card")
	.values("9","txId1","merchantId5","FR","CB","02","TO_CAPTURE","0","0","0","0","0","0","0","0","0","0","0","0","0","100","20060601","2012-07-26 15:05:00","opp","978","Card")
	.values("10","txId2","merchantId5","FR","CB","02","TO_CAPTURE","0","0","0","0","0","0","0","0","0","0","0","0","0","100","20060601","2012-07-26 15:05:00","opp","978","Card")
	.values("11","txId1","merchantId6","FR","CB","02","TO_CAPTURE","0","0","0","0","0","0","0","0","0","0","0","0","0","100","20060601","2012-07-26 15:05:00","opp","978","Card")
	.values("12","txId2","merchantId6","FR","CB","02","TO_CAPTURE","0","0","0","0","0","0","0","0","0","0","0","0","0","100","20060601","2012-07-26 15:05:00","opp","978","Card")
	.values("13","txId2","merchantId7","FR","CB","02","TO_CAPTURE","0","0","0","0","0","0","0","0","0","0","0","0","0","100","20060601","2012-07-26 15:05:00","opp","978","Card")
	.values("14","txId2","merchantId7","FR","CB","02","TO_CAPTURE","0","0","0","0","0","0","0","0","0","0","0","0","0","100","20060601","2012-07-26 15:05:00","opp","978","Card")
	.values("15","txId2","merchantId8","FR","CB","02","TO_CAPTURE","0","0","0","0","0","0","0","0","0","0","0","0","0","100","20060601","2012-07-26 15:05:00","opp","978","Card")
	.values("16","txId2","merchantId8","FR","CB","02","TO_CAPTURE","0","0","0","0","0","0","0","0","0","0","0","0","0","100","20060601","2012-07-26 15:05:00","opp","978","Card")
	.values("17","txId2","merchantId9","FR","CB","02","TO_CAPTURE","0","0","0","0","0","0","0","0","0","0","0","0","0","100","20060601","2012-07-26 15:05:00","opp","978","Card")
	.values("18","txId2","merchantId9","FR","CB","02","TO_CAPTURE","0","0","0","0","0","0","0","0","0","0","0","0","0","100","20060601","2012-07-26 15:05:00","opp","978","Card")
	.build(),
	insertInto("SETTLE_SETTLEMENT_FILES")
	.columns("ID_SETTLEFILE","ACQ_SYS_ALIAS","FILE_ALIAS","MERCHANT_PROFILE","NETWORK_ALIAS","OFFER","TECHNO","NO_OF_SETTLE_MOVEMENT","STATUS","EXECUTION_MODE")
	.values("uid","CTC1","CAPTURE_SIPS","1D","CB","SIPS","SSL","0","FILE_CREATED","PRODUCTION")
	.build(),
	insertInto("SETTLE_SETTLEMENT_MOVEMENTS")
	.columns("ID_SETTLEMVT","SETTLEMENT_STATUS","ID_OPERATION")
	.values("1","TO_SETTLE","1")
	.values("2","TO_SETTLE","2")
	.values("3","TO_SETTLE","3")
	.values("4","TO_SETTLE","4")
	.values("5","TO_SETTLE","5")
	.values("6","TO_SETTLE","6")
	.values("7","TO_SETTLE","7")
	.values("8","TO_SETTLE","8")
	.values("9","TO_SETTLE","9")
	.values("10","TO_SETTLE","10")
	.values("11","TO_SETTLE","11")
	.values("12","TO_SETTLE","12")
	.values("13","TO_SETTLE","13")
	.values("14","TO_SETTLE","14")
	.values("15","TO_SETTLE","15")
	.values("16","TO_SETTLE","16")
	.values("17","TO_SETTLE","17")
	.values("18","TO_SETTLE","18")
	.build());

	public static final Operation settleCoreTemptablemanagementFillTempTable =
 	sequenceOf(
	deleteAllFrom("SETTLE_OPERATIONS_TEMP0","SETTLE_OPERATIONS_TEMP1","SETTLE_OPERATIONS_TEMP2","SETTLE_OPERATIONS_TEMP3","SETTLE_OPERATIONS_TEMP4","SETTLE_OPERATIONS_TEMP5","SETTLE_OPERATIONS_TEMP6"),
	insertInto("SETTLE_OPERATIONS_TEMP0")
	.columns("ID_OPERATION","NETWORK_ALIAS","NETWORK_ID","STATUS","ITEM_OPERATION","REFITEM_OPERATION")
	.values("id1","alias","nt","TO_CAPTURE","0","0")
	.values("id2","alias","nt","TO_CAPTURE","0","0")
	.values("id3","alias","nt","TO_CAPTURE","0","0")
	.values("id4","alias","nt","TO_CAPTURE","0","0")
	.values("id5","alias","nt","TO_CAPTURE","0","0")
	.build(),
	insertInto("SETTLE_OPERATIONS_TEMP1")
	.columns("ID_OPERATION","NETWORK_ALIAS","NETWORK_ID","STATUS","ITEM_OPERATION","REFITEM_OPERATION")
	.values("id1","alias","nt","TO_CAPTURE","0","0")
	.values("id2","alias","nt","TO_CAPTURE","0","0")
	.values("id3","alias","nt","TO_CAPTURE","0","0")
	.values("id4","alias","nt","TO_CAPTURE","0","0")
	.values("id5","alias","nt","TO_CAPTURE","0","0")
	.build(),
	insertInto("SETTLE_OPERATIONS_TEMP2")
	.columns("ID_OPERATION","NETWORK_ALIAS","NETWORK_ID","STATUS","ITEM_OPERATION","REFITEM_OPERATION")
	.values("id1","alias","nt","TO_CAPTURE","0","0")
	.values("id2","alias","nt","TO_CAPTURE","0","0")
	.values("id3","alias","nt","TO_CAPTURE","0","0")
	.values("id4","alias","nt","TO_CAPTURE","0","0")
	.values("id5","alias","nt","TO_CAPTURE","0","0")
	.build(),
	insertInto("SETTLE_OPERATIONS_TEMP3")
	.columns("ID_OPERATION","NETWORK_ALIAS","NETWORK_ID","STATUS","ITEM_OPERATION","REFITEM_OPERATION")
	.values("id1","alias","nt","TO_CAPTURE","0","0")
	.values("id2","alias","nt","TO_CAPTURE","0","0")
	.values("id3","alias","nt","TO_CAPTURE","0","0")
	.values("id4","alias","nt","TO_CAPTURE","0","0")
	.values("id5","alias","nt","TO_CAPTURE","0","0")
	.build(),
	insertInto("SETTLE_OPERATIONS_TEMP4")
	.columns("ID_OPERATION","NETWORK_ALIAS","NETWORK_ID","STATUS","ITEM_OPERATION","REFITEM_OPERATION")
	.values("id1","alias","nt","TO_CAPTURE","0","0")
	.values("id2","alias","nt","TO_CAPTURE","0","0")
	.values("id3","alias","nt","TO_CAPTURE","0","0")
	.values("id4","alias","nt","TO_CAPTURE","0","0")
	.values("id5","alias","nt","TO_CAPTURE","0","0")
	.build(),
	insertInto("SETTLE_OPERATIONS_TEMP5")
	.columns("ID_OPERATION","NETWORK_ALIAS","NETWORK_ID","STATUS","ITEM_OPERATION","REFITEM_OPERATION")
	.values("id1","alias","nt","TO_CAPTURE","0","0")
	.values("id2","alias","nt","TO_CAPTURE","0","0")
	.values("id3","alias","nt","TO_CAPTURE","0","0")
	.values("id4","alias","nt","TO_CAPTURE","0","0")
	.values("id5","alias","nt","TO_CAPTURE","0","0")
	.build(),
	insertInto("SETTLE_OPERATIONS_TEMP6")
	.columns("ID_OPERATION","NETWORK_ALIAS","NETWORK_ID","STATUS","ITEM_OPERATION","REFITEM_OPERATION")
	.values("id1","alias","nt","TO_CAPTURE","0","0")
	.values("id2","alias","nt","TO_CAPTURE","0","0")
	.values("id3","alias","nt","TO_CAPTURE","0","0")
	.values("id4","alias","nt","TO_CAPTURE","0","0")
	.values("id5","alias","nt","TO_CAPTURE","0","0")
	.build());

	public static final Operation settleCoreTemptablemanagementTempTable0Queries =
 	sequenceOf(
	deleteAllFrom("SETTLE_OPERATIONS_TEMP0","SETTLE_OPERATIONS_TEMP1","SETTLE_OPERATIONS_TEMP2","SETTLE_OPERATIONS_TEMP3","SETTLE_OPERATIONS_TEMP4"),
	insertInto("SETTLE_OPERATIONS_TEMP0")
	.columns("ID_OPERATION","NETWORK_ALIAS","NETWORK_ID","STATUS","ITEM_OPERATION","REFITEM_OPERATION")
	.values("id1","alias","nt","TO_CAPTURE","0","0")
	.values("id2","alias","nt","TO_CAPTURE","0","0")
	.values("id3","alias","nt","TO_CAPTURE","0","0")
	.values("id4","alias","nt","TO_CAPTURE","0","0")
	.values("id5","alias","nt","TO_CAPTURE","0","0")
	.build());

	public static final Operation settleCoreTemptablemanagementTempTable1Queries =
 	sequenceOf(
	deleteAllFrom("SETTLE_OPERATIONS_TEMP1","SETTLE_OPERATIONS_TEMP0","SETTLE_OPERATIONS_TEMP2","SETTLE_OPERATIONS_TEMP3","SETTLE_OPERATIONS_TEMP4"),
	insertInto("SETTLE_OPERATIONS_TEMP1")
	.columns("ID_OPERATION","NETWORK_ALIAS","NETWORK_ID","STATUS","ITEM_OPERATION","REFITEM_OPERATION")
	.values("id1","alias","nt","TO_CAPTURE","0","0")
	.values("id2","alias","nt","TO_CAPTURE","0","0")
	.values("id3","alias","nt","TO_CAPTURE","0","0")
	.values("id4","alias","nt","TO_CAPTURE","0","0")
	.values("id5","alias","nt","TO_CAPTURE","0","0")
	.build());

	public static final Operation settleCoreTemptablemanagementTempTable2Queries =
 	sequenceOf(
	deleteAllFrom("SETTLE_OPERATIONS_TEMP2","SETTLE_OPERATIONS_TEMP0","SETTLE_OPERATIONS_TEMP1","SETTLE_OPERATIONS_TEMP3","SETTLE_OPERATIONS_TEMP4"),
	insertInto("SETTLE_OPERATIONS_TEMP2")
	.columns("ID_OPERATION","NETWORK_ALIAS","NETWORK_ID","STATUS","ITEM_OPERATION","REFITEM_OPERATION")
	.values("id1","alias","nt","TO_CAPTURE","0","0")
	.values("id2","alias","nt","TO_CAPTURE","0","0")
	.values("id3","alias","nt","TO_CAPTURE","0","0")
	.values("id4","alias","nt","TO_CAPTURE","0","0")
	.values("id5","alias","nt","TO_CAPTURE","0","0")
	.build());

	public static final Operation settleCoreTemptablemanagementTempTable3Queries =
 	sequenceOf(
	deleteAllFrom("SETTLE_OPERATIONS_TEMP3","SETTLE_OPERATIONS_TEMP0","SETTLE_OPERATIONS_TEMP1","SETTLE_OPERATIONS_TEMP2","SETTLE_OPERATIONS_TEMP4"),
	insertInto("SETTLE_OPERATIONS_TEMP3")
	.columns("ID_OPERATION","NETWORK_ALIAS","NETWORK_ID","STATUS","ITEM_OPERATION","REFITEM_OPERATION")
	.values("id1","alias","nt","TO_CAPTURE","0","0")
	.values("id2","alias","nt","TO_CAPTURE","0","0")
	.values("id3","alias","nt","TO_CAPTURE","0","0")
	.values("id4","alias","nt","TO_CAPTURE","0","0")
	.values("id5","alias","nt","TO_CAPTURE","0","0")
	.build());

	public static final Operation settleCoreTemptablemanagementTempTable4Queries =
 	sequenceOf(
	deleteAllFrom("SETTLE_OPERATIONS_TEMP4","SETTLE_OPERATIONS_TEMP0","SETTLE_OPERATIONS_TEMP1","SETTLE_OPERATIONS_TEMP2","SETTLE_OPERATIONS_TEMP3"),
	insertInto("SETTLE_OPERATIONS_TEMP4")
	.columns("ID_OPERATION","NETWORK_ALIAS","NETWORK_ID","STATUS","ITEM_OPERATION","REFITEM_OPERATION")
	.values("id1","alias","nt","TO_CAPTURE","0","0")
	.values("id2","alias","nt","TO_CAPTURE","0","0")
	.values("id3","alias","nt","TO_CAPTURE","0","0")
	.values("id4","alias","nt","TO_CAPTURE","0","0")
	.values("id5","alias","nt","TO_CAPTURE","0","0")
	.build());

	public static final Operation settleCoreTemptablemanagementTempTable5Queries =
 	sequenceOf(
	deleteAllFrom("SETTLE_OPERATIONS_TEMP5","SETTLE_OPERATIONS_TEMP0","SETTLE_OPERATIONS_TEMP1","SETTLE_OPERATIONS_TEMP2","SETTLE_OPERATIONS_TEMP3"),
	insertInto("SETTLE_OPERATIONS_TEMP5")
	.columns("ID_OPERATION","NETWORK_ALIAS","NETWORK_ID","STATUS","ITEM_OPERATION","REFITEM_OPERATION")
	.values("id1","alias","nt","TO_CAPTURE","0","0")
	.values("id2","alias","nt","TO_CAPTURE","0","0")
	.values("id3","alias","nt","TO_CAPTURE","0","0")
	.values("id4","alias","nt","TO_CAPTURE","0","0")
	.values("id5","alias","nt","TO_CAPTURE","0","0")
	.build());

	public static final Operation settleCoreTemptablemanagementTempTable6Queries =
 	sequenceOf(
	deleteAllFrom("SETTLE_OPERATIONS_TEMP6","SETTLE_OPERATIONS_TEMP0","SETTLE_OPERATIONS_TEMP1","SETTLE_OPERATIONS_TEMP2","SETTLE_OPERATIONS_TEMP3"),
	insertInto("SETTLE_OPERATIONS_TEMP6")
	.columns("ID_OPERATION","NETWORK_ALIAS","NETWORK_ID","STATUS","ITEM_OPERATION","REFITEM_OPERATION")
	.values("id1","alias","nt","TO_CAPTURE","0","0")
	.values("id2","alias","nt","TO_CAPTURE","0","0")
	.values("id3","alias","nt","TO_CAPTURE","0","0")
	.values("id4","alias","nt","TO_CAPTURE","0","0")
	.values("id5","alias","nt","TO_CAPTURE","0","0")
	.build());

	public static final Operation settleCoreTransactionOperationManagementTestCase =
 	sequenceOf(
	deleteAllFrom("SETTLE_SETTLEMENT_FILES","SETTLE_SESSIONS","SETTLE_OPERATIONS","SETTLE_SETTLEMENT_MOVEMENTS","SETTLE_OPERATION_DETAILS"),
	insertInto("SETTLE_SESSIONS")
	.columns("ID_SESSION","AIID","AUTHORIZATION_NB_OPERATIONS","AUTHORIZATION_TOTAL_AMOUNT","FULL_CANCEL_NB_OPERATIONS","FULL_CANCEL_TOTAL_AMOUNT","FULL_REFUND_NB_OPERATIONS","FULL_REFUND_TOTAL_AMOUNT","PARTIAL_CANCEL_NB_OPERATIONS","PARTIAL_CANCEL_TOTAL_AMOUNT","PARTIAL_REFUND_NB_OPERATIONS","PARTIAL_REFUND_TOTAL_AMOUNT","SESSION_DATE","SESSION_NUMBER","STATUS","ACQUIRER_ID")
	.values("SID_01","aiid","1","100","2","200","3","300","4","400","5","500","2012-07-26 14:05:00","1","OPENED","00")
	.values("SID_01bis","aiid","1","100","2","200","3","300","4","400","5","500","2012-07-26 14:05:00","1","OPENED","00")
	.values("SID_02","aiid","1","100","2","200","3","300","4","400","5","500","2012-07-26 14:05:00","1","CLOSED","00")
	.build(),
	insertInto("SETTLE_OPERATIONS")
	.columns("ID_OPERATION","TRANSACTION_ID","MERCHANT_ID","MERCHANT_COUNTRY","NETWORK_ALIAS","NETWORK_ID","STATUS","AUTHOR_COUNT","CASH_AMOUNT_VALUE","CONSUMER_CREDITAMOUNT_VALUE","OPER_AMOUNT_VALUE","OVERTAKE_AMOUNT_VALUE","CVV_FLAG","ORIGIN_AMOUNT_VALUE","PAYMENT_NB","KEY_SIPS","DUEDATE_NUM","ITEM_OPERATION","REFITEM_OPERATION","PAYMENT_SEQ","CURRENT_TRANSAMOUNT_VALUE","dateNum","CAPTURE_LIMIT_DATE","OPP_REF","ID_SESSION")
	.values("1","txId1","merchantId1","FR","CB","CT","TO_CAPTURE","0","0","0","0","0","0","0","0","0","0","0","0","0","100","20060601","2012-07-26 15:05:00","opp")
	.values("5","txId5","merchantId5","FR","CB","CT","TO_CAPTURE","0","0","0","0","0","0","0","0","0","0","0","0","0","100","20060601","2012-07-26 15:05:00","opp")
	.values("6","txId6","merchantId66666","FR","CB","CT","TO_CAPTURE","0","0","0","0","0","0","0","0","0","0","0","0","0","100","20060601","2012-07-26 15:05:00","opp")
	.values("7","txId7","merchantId7","FR","CB","CT","TO_CREDIT","0","0","0","0","0","0","0","0","0","0","0","0","0","20","20060601","2012-07-26 15:05:00","opp")
	.values("8","txId8","merchantId8","FR","CB","CT","TO_CAPTURE","0","0","0","0","0","0","0","0","0","0","0","0","0","20","20060601","2012-07-26 15:05:00","opp")
	.values("9","txId9","merchantId9","FR","CB","CT","TO_CAPTURE","0","0","0","0","0","0","0","0","0","0","0","0","0","20","20060601","2012-07-26 15:05:00","opp")
	.values("10","txId10","merchantId10","FR","CB","CT","TO_CAPTURE","0","0","0","0","0","0","0","0","0","0","0","0","0","20","20060601","2012-07-26 15:05:00","opp","SID_01")
	.values("11","txId11","merchantId10","FR","CB","CT","TO_CAPTURE","0","0","0","0","0","0","0","0","0","0","0","0","0","20","20060601","2012-07-26 15:05:00","opp","SID_02")
	.values("12","txId12","merchantId12","FR","CB","CT","TO_CAPTURE","0","0","0","0","0","0","0","0","0","0","0","0","0","20","20060601","2012-07-26 15:05:00","opp")
	.values("13","txId13","merchantId13","FR","CB","CT","TO_CAPTURE","0","0","0","0","0","0","0","0","0","0","0","0","0","20","20060601","2012-07-26 15:05:00","opp","SID_01")
	.values("14","txId14","merchantId14","FR","CB","CT","TO_CAPTURE","0","0","0","0","0","0","0","0","0","0","0","0","0","20","20060601","2012-07-26 15:05:00","opp","SID_01")
	.values("15","txId15","merchantId15","FR","CB","CT","TO_CAPTURE","0","0","0","0","0","0","0","0","0","0","0","0","0","20","20060601","2012-07-26 15:05:00","opp")
	.build(),
	insertInto("SETTLE_SETTLEMENT_MOVEMENTS")
	.columns("ID_SETTLEMVT","SETTLEMENT_STATUS","ID_OPERATION")
	.values("1","TO_SETTLE","1")
	.values("5","SETTLE_OK","5")
	.values("6","TO_SETTLE","6")
	.values("7","TO_SETTLE","7")
	.values("8","SETTLE_OK","8")
	.values("9","TO_SETTLE","9")
	.values("10","TO_SETTLE","10")
	.values("11","TO_SETTLE","11")
	.values("12","TO_SETTLE","12")
	.values("13","TO_SETTLE","13")
	.values("14","TO_SETTLE","14")
	.values("15","WAITING_SETTLE","15")
	.build(),
	insertInto("SETTLE_OPERATION_DETAILS")
	.columns("ID_OPER_DETAIL","ACCEPTOR_ID","AMOUNT_ISOCODE","AMOUNT_VALUE","AUTHORIZATION_CODE","CARD_TYPE","CIPHER_CARD_NUMBER","DATE_NUM","DATE_TIME_TRANSACTION","MERCHANT_BANK_CODE","MESSAGE_TYPE","ORIGIN_AMOUNT_ISOCODE","ORIGIN_AMOUNT_VALUE","ORIGINAL_OPER_TRANSACTION_DATE","ORIGINAL_OPER_MESSAGE_TYPE","ORIGINAL_OPER_TRANSACTION_ID","STAN","TRANSACTION_ID","ID_SESSION")
	.values("1","cept","EUR","100","01","02","123456789XYZ","20060601","2012-07-26 15:05:00","12","AUTHORIZATION","EUR","100","2012-07-26 14:05:00","DUAL","txId10","stan0","txId10","SID_01")
	.values("2","cept","EUR","100","01","02","123456789XYZ","20060601","2012-07-26 15:05:00","12","AUTHORIZATION","EUR","100","2012-07-26 14:05:00","DUAL","txId10","stan0","txId10","SID_02")
	.build());

	public static final Operation settleCoreTransactionOperationQueriesTestCase =
 	sequenceOf(
	deleteAllFrom("SETTLE_SETTLEMENT_FILES","SETTLE_ACQUIRERS","SETTLE_SESSIONS","SETTLE_OPERATIONS","SETTLE_SETTLEMENT_MOVEMENTS","SETTLE_OPERATION_DETAILS","SETTLE_CONTRACTS","SETTLE_SETTLEMENT_PARAMETERS"),
	insertInto("SETTLE_ACQUIRERS")
	.columns("ID_ACQUIRER","ACQ_SYS_ALIAS","ACQ_COMMENT")
	.values("00","CTC0","ctc merchant")
	.build(),
	insertInto("SETTLE_SESSIONS")
	.columns("ID_SESSION","AIID","AUTHORIZATION_NB_OPERATIONS","AUTHORIZATION_TOTAL_AMOUNT","FULL_CANCEL_NB_OPERATIONS","FULL_CANCEL_TOTAL_AMOUNT","FULL_REFUND_NB_OPERATIONS","FULL_REFUND_TOTAL_AMOUNT","PARTIAL_CANCEL_NB_OPERATIONS","PARTIAL_CANCEL_TOTAL_AMOUNT","PARTIAL_REFUND_NB_OPERATIONS","PARTIAL_REFUND_TOTAL_AMOUNT","SESSION_DATE","SESSION_NUMBER","STATUS","ACQUIRER_ID")
	.values("SID_01","aiid","1","100","2","200","3","300","4","400","5","500","2012-07-26 14:05:00","1","OPENED","00")
	.values("SID_02","aiid","1","100","2","200","3","300","4","400","5","500","2012-07-26 14:05:00","1","CLOSED","00")
	.build(),
	insertInto("SETTLE_OPERATIONS")
	.columns("ID_OPERATION","OPP_REF","TRANSACTION_ID","MERCHANT_ID","MERCHANT_COUNTRY","NETWORK_ALIAS","NETWORK_ID","STATUS","AUTHOR_COUNT","CASH_AMOUNT_VALUE","CONSUMER_CREDITAMOUNT_VALUE","OPER_AMOUNT_VALUE","OVERTAKE_AMOUNT_VALUE","CVV_FLAG","ORIGIN_AMOUNT_VALUE","PAYMENT_NB","KEY_SIPS","DUEDATE_NUM","ITEM_OPERATION","REFITEM_OPERATION","PAYMENT_SEQ","CURRENT_TRANSAMOUNT_VALUE","dateNum","CAPTURE_LIMIT_DATE","ACCEPTOR_TYPE_ALIAS","TERMINAL_ID","TRANSACTION_REF","ID_SESSION")
	.values("1","merchantId1#BE#txId1#2006-06-01","txId1","merchantId1","BE","CB","02","TO_CAPTURE","0","0","0","0","0","0","0","0","0","0","0","0","0","100","20060601","2012-07-29 15:05:03","DCC","1","trxnRef")
	.values("2","merchantId1#BE#txId2#2006-06-02","txId2","merchantId1","BE","INDIA","90","TO_CAPTURE","0","0","0","0","0","0","0","0","0","0","0","0","0","100","20060602","2012-07-29 15:05:03","DCC","2","1")
	.values("3","merchantId1#BE#txId3#2006-06-02","txId2","merchantId1","BE","INDIA","90","TO_CAPTURE","0","0","0","0","0","0","0","0","0","0","0","0","0","100","20060602","2012-07-29 15:05:03","DCC","3","1","SID_01")
	.values("11","merchantId1#BE#txId2#2006-06-11","txId2","merchantId1","BE","BANKSYS","63","TO_CAPTURE","0","0","0","0","0","0","0","0","0","0","0","0","0","100","20060611","2012-07-29 15:05:03","SSL","3","1")
	.values("12","merchantId2#BE#txId2#2006-06-12","txId2","merchantId2","BE","BANKSYS","02","TO_CAPTURE","0","0","0","0","0","0","0","0","0","0","0","0","0","100","20060612","2018-07-29 15:05:03","SSL","4","1")
	.values("101","merchantId1#FR#txId3#2006-06-01","txId3","merchantId1","FR","CTC","02","TO_CREDIT","0","0","0","0","0","0","0","0","0","0","0","0","0","100","20060601","5","trxnRef")
	.values("1001","merchantId1000#FR#txId1#2006-06-01","txId1","merchantId1000","FR","CB","02","TO_CAPTURE","0","0","0","0","0","0","0","0","0","0","0","0","0","100","20060601","2012-07-29 15:05:03","SSL","6","trxnRef")
	.values("1002","merchantId1000#FR#txId2#2006-06-01","txId2","merchantId1000","FR","CB","02","TO_CAPTURE","0","0","0","0","0","0","0","0","0","0","0","0","0","100","20060601","2012-07-29 15:05:03","SSL","7","trxnRef")
	.values("1003","merchantId1000#FR#txId3#2006-06-01","txId3","merchantId1000","FR","CB","02","TO_CAPTURE","0","0","0","0","0","0","0","0","0","0","0","0","0","100","20060601","2012-07-29 15:05:03","SSL","8","trxnRef")
	.values("1004","merchantId1000#FR#txId4#2006-06-01","txId4","merchantId1000","FR","CB","02","TO_CAPTURE","0","0","0","0","0","0","0","0","0","0","0","0","0","100","20060601","2012-07-29 15:05:03","SSL","8","trxnRef")
	.values("1005","merchantId1000#FR#txId4#2006-06-01","txId4","merchantId1000","FR","CB","02","TO_CAPTURE","0","0","0","0","0","0","0","0","0","0","0","0","0","100","20060601","2012-07-29 15:05:03","SSL","8","trxnRef","SID_01")
	.values("SID02_op1","merchantId1000#FR#txId4#2006-06-01","txId4","merchantId1000","FR","CB","02","TO_CAPTURE","0","0","0","0","0","0","0","0","0","0","0","0","0","100","20060601","2012-07-29 15:05:03","SSL","8","trxnRef","SID_02")
	.values("op11","merchantId1001#FR#txId11#20060601","txId11","merchantId1001","FR","CB","02","TO_CAPTURE","0","0","0","0","0","0","0","0","0","0","0","0","0","100","20060601","2012-07-29 15:05:03","SSL","8","trxnRef")
	.build(),
	insertInto("SETTLE_SETTLEMENT_MOVEMENTS")
	.columns("ID_SETTLEMVT","SETTLEMENT_STATUS","ID_OPERATION")
	.values("1","TO_SETTLE","1")
	.values("2","TO_SETTLE","2")
	.values("3","TO_SETTLE","3")
	.values("11","TO_SETTLE","11")
	.values("12","TO_SETTLE","12")
	.values("101","TO_SETTLE","101")
	.values("1001","TO_SETTLE","1001")
	.values("1002","TO_SETTLE","1002")
	.values("1003","TO_SETTLE","1003")
	.values("1004","SETTLE_OK","1004")
	.values("1005","TO_SETTLE","1005")
	.values("SID02_op1","TO_SETTLE","SID02_op1")
	.values("sm11","TO_SETTLE","op11")
	.build());

	public static final Operation settleCoreTransactionPurgeManagerTestCase =
 	sequenceOf(
	deleteAllFrom("SETTLE_SETTLEMENT_FILES","SETTLE_OPERATIONS","SETTLE_SETTLEMENT_MOVEMENTS"),
	insertInto("SETTLE_SETTLEMENT_FILES")
	.columns("ID_SETTLEFILE","ACQ_SYS_ALIAS","FILE_ALIAS","MERCHANT_PROFILE","END_DATE_TIME","NETWORK_ALIAS","OFFER","TECHNO","NO_OF_SETTLE_MOVEMENT","STATUS","EXECUTION_MODE")
	.values("1","CTC1","CAPTURE_SIPS","1D","2012-07-08 15:05:00","CB","SIPS","SSL","0","FILE_CREATED","PRODUCTION")
	.values("2","CTC2","CAPTURE_SIPS","1D","2012-07-08 15:05:00","CB","SIPS","SSL","0","ENDED","PRODUCTION")
	.values("3","CTC3","CAPTURE_SIPS","1D","2048-11-30 15:05:00","CB","SIPS","SSL","3","ENDED","PRODUCTION")
	.build(),
	insertInto("SETTLE_OPERATIONS")
	.columns("ID_OPERATION","TRANSACTION_ID","MERCHANT_ID","MERCHANT_COUNTRY","NETWORK_ALIAS","NETWORK_ID","STATUS","AUTHOR_COUNT","CASH_AMOUNT_VALUE","CONSUMER_CREDITAMOUNT_VALUE","OPER_AMOUNT_VALUE","OVERTAKE_AMOUNT_VALUE","CVV_FLAG","ORIGIN_AMOUNT_VALUE","PAYMENT_NB","KEY_SIPS","DUEDATE_NUM","ITEM_OPERATION","REFITEM_OPERATION","PAYMENT_SEQ","CURRENT_TRANSAMOUNT_VALUE","dateNum","CAPTURE_LIMIT_DATE","OPP_REF")
	.values("1","tnxId1","merchantId1","FR","CB","CB","TO_CAPTURE","0","0","0","0","0","0","0","0","0","0","0","0","0","100","20060601","2012-07-26 15:05:00","opp")
	.values("2","tnxId5","merchantId55555","F5","CB","CB","TO_CAPTURE","0","0","0","0","0","0","0","0","0","0","0","0","0","100","20060601","2012-07-26 15:05:00","opp")
	.values("3","tnxId6","merchantId66666","F6","CB","CB","TO_CAPTURE","0","0","0","0","0","0","0","0","0","0","0","0","0","100","20060601","2012-07-26 15:05:00","opp")
	.values("4","tnxId7","merchantId77777","F7","CB","CB","TO_CREDIT","0","0","0","0","0","0","0","0","0","0","0","0","0","20","20060601","2012-07-26 15:05:00","opp")
	.values("5","tnxId8","merchantId88888","F8","CB","CB","TO_CAPTURE","0","0","0","0","0","0","0","0","0","0","0","0","0","20","20060601","2012-07-26 15:05:00","opp")
	.values("6","tnxId9","merchantId99999","F9","CB","CB","TO_CAPTURE","0","0","0","0","0","0","0","0","0","0","0","0","0","20","20060601","2012-07-26 15:05:00","opp")
	.build(),
	insertInto("SETTLE_SETTLEMENT_MOVEMENTS")
	.columns("ID_SETTLEMVT","SETTLEMENT_STATUS","ID_SETTLEFILE","ID_OPERATION")
	.values("1","TO_SETTLE","1","1")
	.values("2","SETTLE_OK","2","2")
	.values("3","SETTLE_OK","2","3")
	.values("4","SETTLE_OK","3","4")
	.values("5","TO_SETTLE","1","5")
	.values("6","SETTLE_OK","3","6")
	.build());

	public static final Operation settleCoreTransactiondetailOperationDetailQueriesTestCase =
 	sequenceOf(
	deleteAllFrom("SETTLE_ACQUIRERS","SETTLE_SESSIONS","SETTLE_OPERATION_DETAILS","SETTLE_OPERATIONS","SETTLE_SETTLEMENT_MOVEMENTS"),
	insertInto("SETTLE_ACQUIRERS")
	.columns("ID_ACQUIRER","ACQ_SYS_ALIAS","ACQ_COMMENT")
	.values("00","CTC0","ctc merchant")
	.build(),
	insertInto("SETTLE_SESSIONS")
	.columns("ID_SESSION","AIID","AUTHORIZATION_NB_OPERATIONS","AUTHORIZATION_TOTAL_AMOUNT","FULL_CANCEL_NB_OPERATIONS","FULL_CANCEL_TOTAL_AMOUNT","FULL_REFUND_NB_OPERATIONS","FULL_REFUND_TOTAL_AMOUNT","PARTIAL_CANCEL_NB_OPERATIONS","PARTIAL_CANCEL_TOTAL_AMOUNT","PARTIAL_REFUND_NB_OPERATIONS","PARTIAL_REFUND_TOTAL_AMOUNT","SESSION_DATE","SESSION_NUMBER","STATUS","ACQUIRER_ID")
	.values("SID1","aiid","1","100","2","200","3","300","4","400","5","500","2012-07-26 14:05:00","1","OPENED","00")
	.values("SID2","aiid","1","100","2","200","3","300","4","400","5","500","2012-07-26 14:05:00","1","OPENED","00")
	.build(),
	insertInto("SETTLE_OPERATION_DETAILS")
	.columns("ID_OPER_DETAIL","ACCEPTOR_ID","AMOUNT_ISOCODE","AMOUNT_VALUE","AUTHORIZATION_CODE","CARD_TYPE","CIPHER_CARD_NUMBER","DATE_NUM","DATE_TIME_TRANSACTION","MERCHANT_BANK_CODE","MESSAGE_TYPE","ORIGIN_AMOUNT_ISOCODE","ORIGIN_AMOUNT_VALUE","ORIGINAL_OPER_TRANSACTION_DATE","ORIGINAL_OPER_MESSAGE_TYPE","ORIGINAL_OPER_TRANSACTION_ID","STAN","TRANSACTION_ID","ID_SESSION")
	.values("1","accept","EUR","100","01","02","123456789XYZ","20060601","2012-07-26 15:05:00","12","AUTHORIZATION","EUR","100","2012-07-26 14:05:00","DUAL","txnId1","stan","txnId1","SID1")
	.values("2","accept","EUR","100","01","02","123456789XYZ","20060601","2012-07-26 15:05:00","12","AUTHORIZATION","EUR","100","2012-07-26 14:05:00","DUAL","txnId1","stan","txnId1","SID1")
	.values("3","accept","EUR","100","01","02","123456789XYZ","20060601","2012-07-26 15:05:00","12","AUTHORIZATION","EUR","100","2012-07-26 14:05:00","DUAL","txnId1","stan","txnId1","SID1")
	.values("4","accept","EUR","100","01","02","123456789XYZ","20060601","2012-07-26 15:05:00","12","AUTHORIZATION","EUR","100","2012-07-26 14:05:00","DUAL","txnId1","stan","txnId1","SID1")
	.values("5","accept","EUR","100","01","02","123456789XYZ","20060601","2012-07-26 15:05:00","12","AUTHORIZATION","EUR","100","2012-07-26 14:05:00","DUAL","txnId1","stan","txnId1","SID1")
	.values("6","accept","EUR","100","01","02","123456789XYZ","20060601","2012-07-26 15:05:00","12","AUTHORIZATION","EUR","100","2012-07-26 14:05:00","DUAL","txnId1","stan","txnId1","SID2")
	.build(),
	insertInto("SETTLE_OPERATIONS")
	.columns("ID_OPERATION","OPP_REF","TRANSACTION_ID","MERCHANT_ID","MERCHANT_COUNTRY","NETWORK_ALIAS","NETWORK_ID","STATUS","AUTHOR_COUNT","CASH_AMOUNT_VALUE","CONSUMER_CREDITAMOUNT_VALUE","OPER_AMOUNT_VALUE","OVERTAKE_AMOUNT_VALUE","CVV_FLAG","ORIGIN_AMOUNT_VALUE","PAYMENT_NB","KEY_SIPS","DUEDATE_NUM","ITEM_OPERATION","REFITEM_OPERATION","PAYMENT_SEQ","CURRENT_TRANSAMOUNT_VALUE","dateNum","CAPTURE_LIMIT_DATE","ACCEPTOR_TYPE_ALIAS","TERMINAL_ID","ID_SESSION")
	.values("1","merchantId1#FR#txId1#2006-06-01","txId1","merchantId1","BE","CB","02","TO_CAPTURE","0","0","0","0","0","0","0","0","0","0","0","0","0","100","20060601","2012-07-29 15:05:03","DCC","1","SID1")
	.values("2","merchantId2#FR#txId1#2006-06-01","txId1","merchantId2","BE","CB","02","TO_CAPTURE","0","0","0","0","0","0","0","0","0","0","0","0","0","100","20060601","2012-07-29 15:05:03","DCC","SID1")
	.build(),
	insertInto("SETTLE_SETTLEMENT_MOVEMENTS")
	.columns("ID_SETTLEMVT","SETTLEMENT_STATUS","ID_OPERATION")
	.values("1","TO_SETTLE","1")
	.values("2","TO_SETTLE","2")
	.build());

	public static final Operation settleCoreTransactiondetailmanagementSessionManager =
 	sequenceOf(
	deleteAllFrom("SETTLE_SESSIONS","SETTLE_SETTLEMENT_FILES","SETTLE_OPERATION_DETAILS","SETTLE_OPERATIONS","SETTLE_SETTLEMENT_MOVEMENTS"),
	insertInto("SETTLE_SESSIONS")
	.columns("ID_SESSION","AIID","AUTHORIZATION_NB_OPERATIONS","AUTHORIZATION_TOTAL_AMOUNT","FULL_CANCEL_NB_OPERATIONS","FULL_CANCEL_TOTAL_AMOUNT","FULL_REFUND_NB_OPERATIONS","FULL_REFUND_TOTAL_AMOUNT","PARTIAL_CANCEL_NB_OPERATIONS","PARTIAL_CANCEL_TOTAL_AMOUNT","PARTIAL_REFUND_NB_OPERATIONS","PARTIAL_REFUND_TOTAL_AMOUNT","SESSION_DATE","SESSION_NUMBER","STATUS","ACQUIRER_ID")
	.values("SID_OPENED1","aiid","1","100","2","200","3","300","4","400","5","500","2012-07-26 14:05:00","1","OPENED","00")
	.values("SID_BEING1","aiid","1","100","2","200","3","300","4","400","5","500","2012-07-26 14:05:00","1","BEING_CLOSED","00")
	.values("SID_CLOSED1","aiid","1","100","2","200","3","300","4","400","5","500","2012-07-26 14:05:00","1","CLOSED","00")
	.values("SID_OPENED2","aiid","1","100","2","200","3","300","4","400","5","500","2012-07-26 14:05:00","1","OPENED","00")
	.values("SID_BEING2","aiid","1","100","2","200","3","300","4","400","5","500","2012-07-26 14:05:00","1","BEING_CLOSED","00")
	.values("SID_CLOSED2","aiid","1","100","2","200","3","300","4","400","5","500","2012-07-26 14:05:00","1","CLOSED","00")
	.build());

}