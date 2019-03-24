package com.firatergun.gatewaydemo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.firatergun.gatewaydemo.Enum.FilterField;
import com.firatergun.gatewaydemo.domain.request.TransactionRequest;
import com.firatergun.gatewaydemo.entity.Transaction;

@Repository
@Transactional(readOnly=true)
public class TransactionRepositoryImpl implements TransactionRepositoryCustom{

	@PersistenceContext
	EntityManager entityManager;
	
	private final String queryTransactionList 
	= "SELECT tr.* FROM transactions as tr LEFT JOIN customerinfo cu ON tr.customerinfo_Id = cu.Id ";
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Transaction> findByRequest(TransactionRequest request) {
		String whereClause = "";
		boolean whereAdded = false;
		
		if(request.status != null) {
			if(!whereAdded) {
				whereClause += " WHERE ";
				whereAdded = true;
			}  else {
				whereClause += " AND ";
			}
			whereClause += " tr.status = :statusN ";
		}
		if(request.merchantId != null) {
			if(!whereAdded) {
				whereClause += " WHERE ";
				whereAdded = true;
			}  else {
				whereClause += " AND ";
			}
			whereClause += " tr.merchant_Id = :mercId ";
		}
		if(request.fromDate != null && request.toDate != null) {
			if(!whereAdded) {
				whereClause += " WHERE ";
				whereAdded = true;
			}  else {
				whereClause += " AND ";
			}
			whereClause += " tr.transactiondate BETWEEN :fromDate AND :toDate ";
		}
		if(request.filterField != null && request.filterValue != null) {
			if(!whereAdded) {
				whereClause += " WHERE ";
				whereAdded = true;
			}  else {
				whereClause += " AND ";
			}
			if(request.filterField.getText().equalsIgnoreCase(FilterField.CUSTOMER_EMAIL.getText())) {
				whereClause += " cu.email LIKE :email ";
			} else if(request.filterField.getText().equalsIgnoreCase(FilterField.REFERENCE_NO.getText())){
				whereClause += " tr.referenceno = :referenceno ";
			} else if(request.filterField.getText().equalsIgnoreCase(FilterField.TRANSACTION_UUID.getText())) {
				whereClause += " tr.Id = :transactionId ";
			} else {
			}
		}
		if(request.acquirerId != null) {
			if(!whereAdded) {
				whereClause += " WHERE ";
				whereAdded = true;
			}  else {
				whereClause += " AND ";
			}
			whereClause += " tr.acquirer_Id = :acquirerId ";
		}
		
		if(request.errorCode != null) {
			if(!whereAdded) {
				whereClause += " WHERE ";
				whereAdded = true;
			}  else {
				whereClause += " AND ";
			}
			whereClause += " tr.errorcode = :errorcode ";
		}
		
		if(request.operation != null) {
			if(!whereAdded) {
				whereClause += " WHERE ";
				whereAdded = true;
			}  else {
				whereClause += " AND ";
			}
			whereClause += " tr.operation = :operation ";
		}
		
		if(request.paymentMethod != null) {
			if(!whereAdded) {
				whereClause += " WHERE ";
				whereAdded = true;
			}  else {
				whereClause += " AND ";
			}
			whereClause += " tr.paymentmethod = :paymentmethod ";
		}
		
		Query query = entityManager.createNativeQuery(queryTransactionList + whereClause, Transaction.class);
		
		if(request.status != null) {
			query.setParameter("statusN", request.status.toString());
		}
		if(request.merchantId != null) {
			query.setParameter("mercId", request.merchantId);
		}
		if(request.fromDate != null && request.toDate != null) {
			query.setParameter("fromDate", request.fromDate);
			query.setParameter("toDate", request.toDate);
		}
		if(request.filterField != null && request.filterValue != null) {
			if(request.filterField.getText().equalsIgnoreCase(FilterField.CUSTOMER_EMAIL.getText())) {
				whereClause += " cu.email LIKE :email ";
				query.setParameter("email", "%" + request.filterValue.toString() + "%");
			} else if(request.filterField.getText().equalsIgnoreCase(FilterField.REFERENCE_NO.getText())){
				whereClause += " tr.referenceno = :referenceno ";
				query.setParameter("referenceno", request.filterValue);
			} else if(request.filterField.getText().equalsIgnoreCase(FilterField.TRANSACTION_UUID.getText())) {
				whereClause += " tr.Id = :transactionId ";
				query.setParameter("transactionId", request.filterValue);
			} else {
			}
		}
		if(request.acquirerId != null) {
			query.setParameter("acquirerId", request.acquirerId);
		}
		if(request.errorCode != null) {
			query.setParameter("errorcode", request.errorCode.toString());
		}
		if(request.operation != null) {
			query.setParameter("operation", request.operation.toString());
		}
		if(request.paymentMethod != null) {
			query.setParameter("paymentmethod", request.paymentMethod.toString());
		}
		
		List<Transaction> t = query.getResultList();
		return t;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Transaction> findByRequestPaginated(TransactionRequest request) {
		String whereClause = "";
		boolean whereAdded = false;
		
		int pageNumber = 1;
		int pageSize = 1;
		
		if(request.status != null) {
			if(!whereAdded) {
				whereClause += " WHERE ";
				whereAdded = true;
			}  else {
				whereClause += " AND ";
			}
			whereClause += " tr.status = :statusN ";
		}
		if(request.merchantId != null) {
			if(!whereAdded) {
				whereClause += " WHERE ";
				whereAdded = true;
			}  else {
				whereClause += " AND ";
			}
			whereClause += " tr.merchant_Id = :mercId ";
		}
		if(request.fromDate != null && request.toDate != null) {
			if(!whereAdded) {
				whereClause += " WHERE ";
				whereAdded = true;
			}  else {
				whereClause += " AND ";
			}
			whereClause += " tr.transactiondate BETWEEN :fromDate AND :toDate ";
		}
		if(request.filterField != null && request.filterValue != null) {
			if(!whereAdded) {
				whereClause += " WHERE ";
				whereAdded = true;
			}  else {
				whereClause += " AND ";
			}
			if(request.filterField.getText().equalsIgnoreCase(FilterField.CUSTOMER_EMAIL.getText())) {
				whereClause += " cu.email LIKE :email ";
			} else if(request.filterField.getText().equalsIgnoreCase(FilterField.REFERENCE_NO.getText())){
				whereClause += " tr.referenceno = :referenceno ";
			} else if(request.filterField.getText().equalsIgnoreCase(FilterField.TRANSACTION_UUID.getText())) {
				whereClause += " tr.Id = :transactionId ";
			} else {
			}
		}
		if(request.acquirerId != null) {
			if(!whereAdded) {
				whereClause += " WHERE ";
				whereAdded = true;
			}  else {
				whereClause += " AND ";
			}
			whereClause += " tr.acquirer_Id = :acquirerId ";
		}
		
		if(request.errorCode != null) {
			if(!whereAdded) {
				whereClause += " WHERE ";
				whereAdded = true;
			}  else {
				whereClause += " AND ";
			}
			whereClause += " tr.errorcode = :errorcode ";
		}
		
		if(request.operation != null) {
			if(!whereAdded) {
				whereClause += " WHERE ";
				whereAdded = true;
			}  else {
				whereClause += " AND ";
			}
			whereClause += " tr.operation = :operation ";
		}
		
		if(request.paymentMethod != null) {
			if(!whereAdded) {
				whereClause += " WHERE ";
				whereAdded = true;
			}  else {
				whereClause += " AND ";
			}
			whereClause += " tr.paymentmethod = :paymentmethod ";
		}
		
		Query query = entityManager.createNativeQuery(queryTransactionList + whereClause, Transaction.class);
		
		if(request.status != null) {
			query.setParameter("statusN", request.status.toString());
		}
		if(request.merchantId != null) {
			query.setParameter("mercId", request.merchantId);
		}
		if(request.fromDate != null && request.toDate != null) {
			query.setParameter("fromDate", request.fromDate);
			query.setParameter("toDate", request.toDate);
		}
		if(request.filterField != null && request.filterValue != null) {
			if(request.filterField.getText().equalsIgnoreCase(FilterField.CUSTOMER_EMAIL.getText())) {
				whereClause += " cu.email LIKE :email ";
				query.setParameter("email", "%" + request.filterValue.toString() + "%");
			} else if(request.filterField.getText().equalsIgnoreCase(FilterField.REFERENCE_NO.getText())){
				whereClause += " tr.referenceno = :referenceno ";
				query.setParameter("referenceno", request.filterValue);
			} else if(request.filterField.getText().equalsIgnoreCase(FilterField.TRANSACTION_UUID.getText())) {
				whereClause += " tr.Id = :transactionId ";
				query.setParameter("transactionId", request.filterValue);
			} else {
			}
		}
		if(request.acquirerId != null) {
			query.setParameter("acquirerId", request.acquirerId);
		}
		if(request.errorCode != null) {
			query.setParameter("errorcode", request.errorCode.toString());
		}
		if(request.operation != null) {
			query.setParameter("operation", request.operation.toString());
		}
		if(request.paymentMethod != null) {
			query.setParameter("paymentmethod", request.paymentMethod.toString());
		}
		if(request.page != null) {
			pageNumber = request.page;
		}
		if(request.per_page != null) {
			pageSize = request.per_page;
		}
		
		query.setFirstResult((pageNumber-1) * pageSize); 
		query.setMaxResults(pageSize);
		
		List<Transaction> t = query.getResultList();
		return t;
	}
	
	@Override
	public Integer countByRequest(TransactionRequest request) {

		String whereClause = "";
		boolean whereAdded = false;
		
		if(request.status != null) {
			if(!whereAdded) {
				whereClause += " WHERE ";
				whereAdded = true;
			}  else {
				whereClause += " AND ";
			}
			whereClause += " tr.status = :statusN ";
		}
		if(request.merchantId != null) {
			if(!whereAdded) {
				whereClause += " WHERE ";
				whereAdded = true;
			}  else {
				whereClause += " AND ";
			}
			whereClause += " tr.merchant_Id = :mercId ";
		}
		if(request.fromDate != null && request.toDate != null) {
			if(!whereAdded) {
				whereClause += " WHERE ";
				whereAdded = true;
			}  else {
				whereClause += " AND ";
			}
			whereClause += " tr.transactiondate BETWEEN :fromDate AND :toDate ";
		}
		if(request.filterField != null && request.filterValue != null) {
			if(!whereAdded) {
				whereClause += " WHERE ";
				whereAdded = true;
			}  else {
				whereClause += " AND ";
			}
			if(request.filterField.getText().equalsIgnoreCase(FilterField.CUSTOMER_EMAIL.getText())) {
				whereClause += " cu.email LIKE :email ";
			} else if(request.filterField.getText().equalsIgnoreCase(FilterField.REFERENCE_NO.getText())){
				whereClause += " tr.referenceno = :referenceno ";
			} else if(request.filterField.getText().equalsIgnoreCase(FilterField.TRANSACTION_UUID.getText())) {
				whereClause += " tr.Id = :transactionId ";
			} else {
			}
		}
		if(request.acquirerId != null) {
			if(!whereAdded) {
				whereClause += " WHERE ";
				whereAdded = true;
			}  else {
				whereClause += " AND ";
			}
			whereClause += " tr.acquirer_Id = :acquirerId ";
		}
		
		if(request.errorCode != null) {
			if(!whereAdded) {
				whereClause += " WHERE ";
				whereAdded = true;
			}  else {
				whereClause += " AND ";
			}
			whereClause += " tr.errorcode = :errorcode ";
		}
		
		if(request.operation != null) {
			if(!whereAdded) {
				whereClause += " WHERE ";
				whereAdded = true;
			}  else {
				whereClause += " AND ";
			}
			whereClause += " tr.operation = :operation ";
		}
		
		if(request.paymentMethod != null) {
			if(!whereAdded) {
				whereClause += " WHERE ";
				whereAdded = true;
			}  else {
				whereClause += " AND ";
			}
			whereClause += " tr.paymentmethod = :paymentmethod ";
		}
		
		Query query = entityManager.createNativeQuery(queryTransactionList + whereClause, Transaction.class);
		
		if(request.status != null) {
			query.setParameter("statusN", request.status.toString());
		}
		if(request.merchantId != null) {
			query.setParameter("mercId", request.merchantId);
		}
		if(request.fromDate != null && request.toDate != null) {
			query.setParameter("fromDate", request.fromDate);
			query.setParameter("toDate", request.toDate);
		}
		if(request.filterField != null && request.filterValue != null) {
			if(request.filterField.getText().equalsIgnoreCase(FilterField.CUSTOMER_EMAIL.getText())) {
				whereClause += " cu.email LIKE :email ";
				query.setParameter("email", request.filterValue);
			} else if(request.filterField.getText().equalsIgnoreCase(FilterField.REFERENCE_NO.getText())){
				whereClause += " tr.referenceno = :referenceno ";
				query.setParameter("referenceno", request.filterValue);
			} else if(request.filterField.getText().equalsIgnoreCase(FilterField.TRANSACTION_UUID.getText())) {
				whereClause += " tr.Id = :transactionId ";
				query.setParameter("transactionId", request.filterValue);
			} else {
			}
		}
		if(request.acquirerId != null) {
			query.setParameter("acquirerId", request.acquirerId);
		}
		if(request.errorCode != null) {
			query.setParameter("errorcode", request.errorCode.toString());
		}
		if(request.operation != null) {
			query.setParameter("operation", request.operation.toString());
		}
		if(request.paymentMethod != null) {
			query.setParameter("paymentmethod", request.paymentMethod.toString());
		}
		
		Integer count = query.getResultList().size();
		return count;
	}

}
