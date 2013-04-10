package siminov.orm.database.impl;

import siminov.orm.exception.DatabaseException;

/**
 * Exposes API's to returns the minimum non-NULL value of all values in the group.
 * The minimum value is the first non-NULL value that would appear in an ORDER BY of the column.
 * Aggregate min() returns NULL if and only if there are no non-NULL values in the group.
 */
public interface IMin {

	/**
	 * Column name of which condition will be specified.
	 * @param column Name of column.
	 * @return IMinClause Interface.
	 */
	public IMinClause where(String column);
	
	/**
	 * Used to provide manually created Where clause, instead of using API's.
	 * @param whereClause Manually created where clause.
	 * @return IMin Interface.
	 */
	public IMin whereClause(String whereClause);
	
	/**
	 * Used to specify AND condition between where clause.
	 * @param column Name of column on which condition need to be specified.
	 * @return IMinClause Interface.
	 */
	public IMinClause and(String column);
	
	/**
	 * Used to specify OR condition between where clause.
	 * @param column Name of column on which condition need to be specified.
	 * @return IMinClause Interface.
	 */
	public IMinClause or(String column);

	/**
	 * Used to specify GROUP BY statement in conjunction with the aggregate functions to group the result-set by one or more columns.
	 * @param columns Name of columns.
	 * @return IMin Interface.
	 */
	public IMin groupBy(String...columns);
	
	/**
	 * Used to specify HAVING clause to SQL because the WHERE keyword could not be used with aggregate functions.
	 * @param column Name of column on which condition need to be applied.
	 * @return IMinClause Interface.
	 */
	public IMinClause having(String column);

	/**
	 * Used to provide manually created Where clause, instead of using API's.
	 * @param havingClause Where clause.
	 * @return IMin Interface.
	 */
	public IMin havingClause(String havingClause);
	
	/**
	 * Used to provide name of column for which max will be calculated.
	 * @param column Name of column.
	 * @return IMin Interface.
	 */
	public IMin column(String column);
	
	/**
	 * Used to get minimum, this method should be called in last to calculate minimum.
	 * @return Return minimum.
	 * @throws DatabaseException Throws exception if any error occur while calculating minimum. 
	 */
	public Object execute() throws DatabaseException;

}