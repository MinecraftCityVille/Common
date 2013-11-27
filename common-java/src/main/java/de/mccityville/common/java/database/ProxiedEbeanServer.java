package de.mccityville.common.java.database;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.OptimisticLockException;

import com.avaje.ebean.AdminAutofetch;
import com.avaje.ebean.AdminLogging;
import com.avaje.ebean.BackgroundExecutor;
import com.avaje.ebean.BeanState;
import com.avaje.ebean.CallableSql;
import com.avaje.ebean.EbeanServer;
import com.avaje.ebean.ExpressionFactory;
import com.avaje.ebean.Filter;
import com.avaje.ebean.FutureIds;
import com.avaje.ebean.FutureList;
import com.avaje.ebean.FutureRowCount;
import com.avaje.ebean.InvalidValue;
import com.avaje.ebean.PagingList;
import com.avaje.ebean.Query;
import com.avaje.ebean.QueryIterator;
import com.avaje.ebean.QueryResultVisitor;
import com.avaje.ebean.SqlFutureList;
import com.avaje.ebean.SqlQuery;
import com.avaje.ebean.SqlRow;
import com.avaje.ebean.SqlUpdate;
import com.avaje.ebean.Transaction;
import com.avaje.ebean.TxCallable;
import com.avaje.ebean.TxIsolation;
import com.avaje.ebean.TxRunnable;
import com.avaje.ebean.TxScope;
import com.avaje.ebean.Update;
import com.avaje.ebean.ValuePair;
import com.avaje.ebean.cache.ServerCacheManager;
import com.avaje.ebean.config.lucene.LuceneIndex;
import com.avaje.ebean.text.csv.CsvReader;
import com.avaje.ebean.text.json.JsonContext;

public class ProxiedEbeanServer implements EbeanServer {
	
	private EbeanServer server;
	
	public ProxiedEbeanServer(EbeanServer server) {
		this.server = server;
	}
	
	public EbeanServer getProxiedServer() {
		return server;
	}
		
	public AdminLogging getAdminLogging() {
		return server.getAdminLogging();
	}
	
	public AdminAutofetch getAdminAutofetch() {
		return server.getAdminAutofetch();
	}
	
	public LuceneIndex getLuceneIndex(Class<?> beanType) {
		return server.getLuceneIndex(beanType);
	}
	
	public String getName() {
		return server.getName();
	}
	
	public ExpressionFactory getExpressionFactory() {
		return server.getExpressionFactory();
	}
	
	public BeanState getBeanState(Object bean) {
		return server.getBeanState(bean);
	}
	
	public Object getBeanId(Object bean) {
		return server.getBeanId(bean);
	}
	
	public Map<String, ValuePair> diff(Object a, Object b) {
		return server.diff(a, b);
	}
	
	public InvalidValue validate(Object bean) {
		return server.validate(bean);
	}
	
	public InvalidValue[] validate(Object bean, String propertyName, Object value) {
		return server.validate(bean, propertyName, value);
	}
	
	public <T> T createEntityBean(Class<T> type) {
		return server.createEntityBean(type);
	}
	
	public ObjectInputStream createProxyObjectInputStream(InputStream is) {
		return server.createProxyObjectInputStream(is);
	}
	
	public <T> CsvReader<T> createCsvReader(Class<T> beanType) {
		return server.createCsvReader(beanType);
	}
	
	public <T> Query<T> createNamedQuery(Class<T> beanType, String namedQuery) {
		return server.createNamedQuery(beanType, namedQuery);
	}
	
	public <T> Query<T> createQuery(Class<T> beanType, String query) {
		return server.createQuery(beanType, query);
	}
	
	public <T> Query<T> createQuery(Class<T> beanType) {
		return server.createQuery(beanType);
	}
	
	public <T> Query<T> find(Class<T> beanType) {
		return server.find(beanType);
	}
	
	public Object nextId(Class<?> beanType) {
		return server.nextId(beanType);
	}
	
	public <T> Filter<T> filter(Class<T> beanType) {
		return server.filter(beanType);
	}
	
	public <T> void sort(List<T> list, String sortByClause) {
		server.sort(list, sortByClause);
	}
	
	public <T> Update<T> createNamedUpdate(Class<T> beanType, String namedUpdate) {
		return server.createNamedUpdate(beanType, namedUpdate);
	}
	
	public <T> Update<T> createUpdate(Class<T> beanType, String ormUpdate) {
		return server.createUpdate(beanType, ormUpdate);
	}
	
	public SqlQuery createSqlQuery(String sql) {
		return server.createSqlQuery(sql);
	}
	
	public SqlQuery createNamedSqlQuery(String namedQuery) {
		return server.createNamedSqlQuery(namedQuery);
	}
	
	public SqlUpdate createSqlUpdate(String sql) {
		return server.createSqlUpdate(sql);
	}
	
	public CallableSql createCallableSql(String callableSql) {
		return server.createCallableSql(callableSql);
	}
	
	public SqlUpdate createNamedSqlUpdate(String namedQuery) {
		return server.createNamedSqlUpdate(namedQuery);
	}
	
	public Transaction createTransaction() {
		return server.createTransaction();
	}
	
	public Transaction createTransaction(TxIsolation isolation) {
		return server.createTransaction(isolation);
	}
	
	public Transaction beginTransaction() {
		return server.beginTransaction();
	}
	
	public Transaction beginTransaction(TxIsolation isolation) {
		return server.beginTransaction(isolation);
	}
	
	public Transaction currentTransaction() {
		return server.currentTransaction();
	}
	
	public void commitTransaction() {
		server.commitTransaction();
	}
	
	public void rollbackTransaction() {
		server.rollbackTransaction();
	}
	
	public void endTransaction() {
		server.endTransaction();
	}
	
	public void logComment(String msg) {
		server.logComment(msg);
	}
	
	public void refresh(Object bean) {
		server.refresh(bean);
	}
	
	public void refreshMany(Object bean, String propertyName) {
		server.refreshMany(bean, propertyName);
	}
	
	public <T> T find(Class<T> beanType, Object uid) {
		return server.find(beanType, uid);
	}
	
	public <T> T getReference(Class<T> beanType, Object uid) {
		return server.getReference(beanType, uid);
	}
	
	public <T> int findRowCount(Query<T> query, Transaction transaction) {
		return server.findRowCount(query, transaction);
	}
	
	public <T> List<Object> findIds(Query<T> query, Transaction t) {
		return server.findIds(query, t);
	}
	
	public <T> QueryIterator<T> findIterate(Query<T> query, Transaction t) {
		return server.findIterate(query, t);
	}
	
	public <T> void findVisit(Query<T> query, QueryResultVisitor<T> visitor, Transaction t) {
		server.findVisit(query, visitor, t);
	}
	
	public <T> List<T> findList(Query<T> query, Transaction transaction) {
		return server.findList(query, transaction);
	}
	
	public <T> FutureRowCount<T> findFutureRowCount(Query<T> query, Transaction t) {
		return server.findFutureRowCount(query, t);
	}
	
	public <T> FutureIds<T> findFutureIds(Query<T> query, Transaction t) {
		return server.findFutureIds(query, t);
	}
	
	public <T> FutureList<T> findFutureList(Query<T> query, Transaction t) {
		return server.findFutureList(query, t);
	}
	
	public SqlFutureList findFutureList(SqlQuery query, Transaction t) {
		return server.findFutureList(query, t);
	}
	
	public <T> PagingList<T> findPagingList(Query<T> query, Transaction t, int pageSize) {
		return server.findPagingList(query, t, pageSize);
	}
	
	public <T> Set<T> findSet(Query<T> query, Transaction transaction) {
		return server.findSet(query, transaction);
	}
	
	public <T> Map<?, T> findMap(Query<T> query, Transaction transaction) {
		return server.findMap(query, transaction);
	}
	
	public <T> T findUnique(Query<T> query, Transaction transaction) {
		return server.findUnique(query, transaction);
	}
	
	public List<SqlRow> findList(SqlQuery query, Transaction transaction) {
		return server.findList(query, transaction);
	}
	
	public Set<SqlRow> findSet(SqlQuery query, Transaction transaction) {
		return server.findSet(query, transaction);
	}
	
	public Map<?, SqlRow> findMap(SqlQuery query, Transaction transaction) {
		return server.findMap(query, transaction);
	}
	
	public SqlRow findUnique(SqlQuery query, Transaction transaction) {
		return server.findUnique(query, transaction);
	}
	
	public void save(Object bean) throws OptimisticLockException {
		server.save(bean);
	}
	
	public int save(Iterator<?> it) throws OptimisticLockException {
		return server.save(it);
	}
	
	public int save(Collection<?> it) throws OptimisticLockException {
		return server.save(it);
	}
	
	public void delete(Object bean) throws OptimisticLockException {
		server.delete(bean);
	}
	
	public int delete(Iterator<?> it) throws OptimisticLockException {
		return server.delete(it);
	}
	
	public int delete(Collection<?> c) throws OptimisticLockException {
		return server.delete(c);
	}
	
	public int delete(Class<?> beanType, Object id) {
		return server.delete(beanType, id);
	}
	
	public int delete(Class<?> beanType, Object id, Transaction t) {
		return server.delete(beanType, id, t);
	}
	
	public void delete(Class<?> beanType, Collection<?> ids) {
		server.delete(beanType, ids);
	}
	
	public void delete(Class<?> beanType, Collection<?> ids, Transaction t) {
		server.delete(beanType, ids, t);
	}
	
	public int execute(SqlUpdate updSql) {
		return server.execute(updSql);
	}
	
	public int execute(Update<?> update) {
		return server.execute(update);
	}
	
	public int execute(Update<?> update, Transaction t) {
		return server.execute(update, t);
	}
	
	public int execute(CallableSql callableSql) {
		return server.execute(callableSql);
	}
	
	public void externalModification(String tableName, boolean inserted, boolean updated, boolean deleted) {
		server.externalModification(tableName, inserted, updated, deleted);
	}
	
	public <T> T find(Class<T> beanType, Object uid, Transaction transaction) {
		return server.find(beanType, uid, transaction);
	}
	
	public void save(Object bean, Transaction t) throws OptimisticLockException {
		server.save(bean, t);
	}
	
	public int save(Iterator<?> it, Transaction t) throws OptimisticLockException {
		return server.save(it, t);
	}
	
	public void update(Object bean) {
		server.update(bean);
	}
	
	public void update(Object bean, Transaction t) {
		server.update(bean, t);
	}
	
	public void update(Object bean, Set<String> updateProps) {
		server.update(bean, updateProps);
	}
	
	public void update(Object bean, Set<String> updateProps, Transaction t) {
		server.update(bean, updateProps, t);
	}
	
	public void update(Object bean, Set<String> updateProps, Transaction t, boolean deleteMissingChildren, boolean updateNullProperties) {
		server.update(bean, updateProps, t, deleteMissingChildren, updateNullProperties);
	}
	
	public void insert(Object bean) {
		server.insert(bean);
	}
	
	public void insert(Object bean, Transaction t) {
		server.insert(bean, t);
	}
	
	public int deleteManyToManyAssociations(Object ownerBean, String propertyName) {
		return server.deleteManyToManyAssociations(ownerBean, propertyName);
	}
	
	public int deleteManyToManyAssociations(Object ownerBean, String propertyName, Transaction t) {
		return server.deleteManyToManyAssociations(ownerBean, propertyName, t);
	}
	
	public void saveManyToManyAssociations(Object ownerBean, String propertyName) {
		server.saveManyToManyAssociations(ownerBean, propertyName);
	}
	
	public void saveManyToManyAssociations(Object ownerBean, String propertyName, Transaction t) {
		server.saveManyToManyAssociations(ownerBean, propertyName, t);
	}

	public void saveAssociation(Object ownerBean, String propertyName) {
		server.saveAssociation(ownerBean, propertyName);
	}
	
	public void saveAssociation(Object ownerBean, String propertyName, Transaction t) {
		server.saveAssociation(ownerBean, propertyName, t);
	}

	public void delete(Object bean, Transaction t) throws OptimisticLockException {
		server.delete(bean, t);
	}
	
	public int delete(Iterator<?> it, Transaction t) throws OptimisticLockException {
		return server.delete(it, t);
	}
	
	public int execute(SqlUpdate updSql, Transaction t) {
		return server.execute(updSql, t);
	}
	
	public int execute(CallableSql callableSql, Transaction t) {
		return server.execute(callableSql, t);
	}
	
	public void execute(TxScope scope, TxRunnable r) {
		server.execute(scope, r);
	}
	
	public void execute(TxRunnable r) {
		server.execute(r);
	}
	
	public <T> T execute(TxScope scope, TxCallable<T> c) {
		return server.execute(scope, c);
	}
	
	public <T> T execute(TxCallable<T> c) {
		return server.execute(c);
	}
	
	public ServerCacheManager getServerCacheManager() {
		return server.getServerCacheManager();
	}
	
	public BackgroundExecutor getBackgroundExecutor() {
		return server.getBackgroundExecutor();
	}
	
	public void runCacheWarming() {
		server.runCacheWarming();
	}
	
	public void runCacheWarming(Class<?> beanType) {
		server.runCacheWarming(beanType);
	}
	
	public JsonContext createJsonContext() {
		return server.createJsonContext();
	}
}
