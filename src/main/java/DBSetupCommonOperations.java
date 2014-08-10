import static com.ninja_squad.dbsetup.Operations.*;
import com.ninja_squad.dbsetup.operation.Operation;

public class DBSetupCommonOperations {
	public static final Operation settleConfigAcquirerAcquirerTestCase =
 	sequenceOf(
deleteAllFrom("SETTLE_ACQUIRERS","SETTLE_CONTRACTS","SETTLE_SETTLEMENT_PARAMETERS","SETTLE_SESSIONS","SETTLE_OPERATION_DETAILS","SETTLE_OPERATIONS","SETTLE_SETTLEMENT_MOVEMENTS"));

	public static final Operation settleConfigSettlementparamContractQueriesTestCase =
 	sequenceOf(
deleteAllFrom("SETTLE_ACQUIRERS","SETTLE_CONTRACTS","SETTLE_SETTLEMENT_PARAMETERS","SETTLE_SESSIONS","SETTLE_OPERATIONS","SETTLE_SETTLEMENT_MOVEMENTS","SETTLE_OPERATION_DETAILS"));

	public static final Operation settleConfigSettlementparamSettlementParameterQueriesTestCase =
 	sequenceOf(
deleteAllFrom("SETTLE_CONTRACTS","SETTLE_SETTLEMENT_PARAMETERS"));

	public static final Operation settleConfigSettlementparamSettlementParamLifeCycleTestCase =
 	sequenceOf(
deleteAllFrom("SETTLE_CONTRACTS","SETTLE_SETTLEMENT_PARAMETERS"));

	public static final Operation settleCoreConciliationConciliationManager =
 	sequenceOf(
deleteAllFrom("SETTLE_SESSIONS","SETTLE_OPERATION_DETAILS","SETTLE_SETTLEMENT_FILES","SETTLE_OPERATIONS","SETTLE_SETTLEMENT_MOVEMENTS"));

	public static final Operation settleCoreReferencesReferenceTableQueriesTest =
 	sequenceOf(
deleteAllFrom("SETTLE_TRANSACTION_STATUSES","SETTLE_CARD_TYPES","SETTLE_ACCEPTOR_TYPE_ALIAS","SETTLE_NETWORK_ALIAS"));

	public static final Operation settleCoreSettlementSettlementFileQueriesTestCase =
 	sequenceOf(
deleteAllFrom("SETTLE_SETTLEMENT_FILES","SETTLE_OPERATIONS","SETTLE_SETTLEMENT_MOVEMENTS"));

	public static final Operation settleCoreSettlementSettlementMovementQueriesTestCase =
 	sequenceOf(
deleteAllFrom("SETTLE_SETTLEMENT_FILES","SETTLE_OPERATIONS","SETTLE_SETTLEMENT_MOVEMENTS"));

	public static final Operation settleCoreSettlementmanagementSettlementManagerTestCase =
 	sequenceOf(
deleteAllFrom("SETTLE_SETTLEMENT_FILES","SETTLE_SESSIONS","SETTLE_OPERATIONS","SETTLE_SETTLEMENT_MOVEMENTS","SETTLE_OPERATION_DETAILS"));

	public static final Operation settleCoreTemptablemanagementCleanTempTable =
 	sequenceOf(
deleteAllFrom("SETTLE_SESSIONS","SETTLE_OPERATION_DETAILS","SETTLE_OPERATIONS_TEMP0","SETTLE_OPERATIONS_TEMP1","SETTLE_OPERATIONS_TEMP2","SETTLE_OPERATIONS_TEMP3","SETTLE_OPERATIONS_TEMP4","SETTLE_OPERATIONS_TEMP5","SETTLE_OPERATIONS_TEMP6","SETTLE_OPERATIONS","SETTLE_SETTLEMENT_FILES","SETTLE_SETTLEMENT_MOVEMENTS"));

	public static final Operation settleCoreTemptablemanagementFillTempTable =
 	sequenceOf(
deleteAllFrom("SETTLE_OPERATIONS_TEMP0","SETTLE_OPERATIONS_TEMP1","SETTLE_OPERATIONS_TEMP2","SETTLE_OPERATIONS_TEMP3","SETTLE_OPERATIONS_TEMP4","SETTLE_OPERATIONS_TEMP5","SETTLE_OPERATIONS_TEMP6"));

	public static final Operation settleCoreTemptablemanagementTempTable0Queries =
 	sequenceOf(
deleteAllFrom("SETTLE_OPERATIONS_TEMP0","SETTLE_OPERATIONS_TEMP1","SETTLE_OPERATIONS_TEMP2","SETTLE_OPERATIONS_TEMP3","SETTLE_OPERATIONS_TEMP4"));

	public static final Operation settleCoreTemptablemanagementTempTable1Queries =
 	sequenceOf(
deleteAllFrom("SETTLE_OPERATIONS_TEMP1","SETTLE_OPERATIONS_TEMP0","SETTLE_OPERATIONS_TEMP2","SETTLE_OPERATIONS_TEMP3","SETTLE_OPERATIONS_TEMP4"));

	public static final Operation settleCoreTemptablemanagementTempTable2Queries =
 	sequenceOf(
deleteAllFrom("SETTLE_OPERATIONS_TEMP2","SETTLE_OPERATIONS_TEMP0","SETTLE_OPERATIONS_TEMP1","SETTLE_OPERATIONS_TEMP3","SETTLE_OPERATIONS_TEMP4"));

	public static final Operation settleCoreTemptablemanagementTempTable3Queries =
 	sequenceOf(
deleteAllFrom("SETTLE_OPERATIONS_TEMP3","SETTLE_OPERATIONS_TEMP0","SETTLE_OPERATIONS_TEMP1","SETTLE_OPERATIONS_TEMP2","SETTLE_OPERATIONS_TEMP4"));

	public static final Operation settleCoreTemptablemanagementTempTable4Queries =
 	sequenceOf(
deleteAllFrom("SETTLE_OPERATIONS_TEMP4","SETTLE_OPERATIONS_TEMP0","SETTLE_OPERATIONS_TEMP1","SETTLE_OPERATIONS_TEMP2","SETTLE_OPERATIONS_TEMP3"));

	public static final Operation settleCoreTemptablemanagementTempTable5Queries =
 	sequenceOf(
deleteAllFrom("SETTLE_OPERATIONS_TEMP5","SETTLE_OPERATIONS_TEMP0","SETTLE_OPERATIONS_TEMP1","SETTLE_OPERATIONS_TEMP2","SETTLE_OPERATIONS_TEMP3"));

	public static final Operation settleCoreTemptablemanagementTempTable6Queries =
 	sequenceOf(
deleteAllFrom("SETTLE_OPERATIONS_TEMP6","SETTLE_OPERATIONS_TEMP0","SETTLE_OPERATIONS_TEMP1","SETTLE_OPERATIONS_TEMP2","SETTLE_OPERATIONS_TEMP3"));

	public static final Operation settleCoreTransactionOperationManagementTestCase =
 	sequenceOf(
deleteAllFrom("SETTLE_SETTLEMENT_FILES","SETTLE_SESSIONS","SETTLE_OPERATIONS","SETTLE_SETTLEMENT_MOVEMENTS","SETTLE_OPERATION_DETAILS"));

	public static final Operation settleCoreTransactionOperationQueriesTestCase =
 	sequenceOf(
deleteAllFrom("SETTLE_SETTLEMENT_FILES","SETTLE_ACQUIRERS","SETTLE_SESSIONS","SETTLE_OPERATIONS","SETTLE_SETTLEMENT_MOVEMENTS","SETTLE_OPERATION_DETAILS","SETTLE_CONTRACTS","SETTLE_SETTLEMENT_PARAMETERS"));

	public static final Operation settleCoreTransactionPurgeManagerTestCase =
 	sequenceOf(
deleteAllFrom("SETTLE_SETTLEMENT_FILES","SETTLE_OPERATIONS","SETTLE_SETTLEMENT_MOVEMENTS"));

	public static final Operation settleCoreTransactiondetailOperationDetailQueriesTestCase =
 	sequenceOf(
deleteAllFrom("SETTLE_ACQUIRERS","SETTLE_SESSIONS","SETTLE_OPERATION_DETAILS","SETTLE_OPERATIONS","SETTLE_SETTLEMENT_MOVEMENTS"));

	public static final Operation settleCoreTransactiondetailmanagementSessionManager =
 	sequenceOf(
deleteAllFrom("SETTLE_SESSIONS","SETTLE_SETTLEMENT_FILES","SETTLE_OPERATION_DETAILS","SETTLE_OPERATIONS","SETTLE_SETTLEMENT_MOVEMENTS"));

}
