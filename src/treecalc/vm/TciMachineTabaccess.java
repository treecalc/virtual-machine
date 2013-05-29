package treecalc.vm;

import java.util.Arrays;

import treecalc.rt.ExceptionCalculation;
import treecalc.rt.V;
import treecalc.vm.asm.TciAssembler.Table;
import treecalc.vm.asm.TciAssembler.TableColumn;

public class TciMachineTabaccess {
	private static final int METHOD_EXACT_STRI = 0;
	private static final int METHOD_INTERVAL_UP = 1;
	private static final int METHOD_INTERVAL_DOWN = 2;

	protected static int getColindex(Table tab, final String name) {
		TableColumn[] columns = tab.tablecolumnarr;
		final String nameup = name.toUpperCase();
		for (int i = 0; i < tab.cols; i++) {
			if (nameup.equals(columns[i].name)) {
				return i;
			}
		}
		return -1;
	}

	public final static int findRowExact(Table tab, V... keys) {
		if (keys.length >= tab.cols) {
			return -1;
		}
		return findRow(tab, METHOD_EXACT_STRI, keys);
	}

	public final static V get(Table tab, int rowind, V columnname) {
		String colname = columnname.stringValue();
		int colind = getColindex(tab, colname);
		if (colind < 0) {
			throw new ExceptionCalculation("column '" + colname + "' does not exist in table " + tab.name, null);
		}
		if (rowind < 0 || rowind >= tab.rows) {
			throw new ExceptionCalculation("row-index " + rowind + " invalid for table " + tab.name, null);
		}
		if (!tab.shuffled) {
			return V.getInstance(tab.data[rowind * tab.cols + colind]);
		} else {
			return V.getInstance(tab.data[tab.oo[rowind] * tab.cols + colind]);
		}
	}

	public final static V get(Table tab, int rowind, int colind) {
		if (colind < 0 || colind >= tab.cols) {
			throw new ExceptionCalculation("column with index " + colind + " does not exist in table " + tab.name, null);
		}
		if (rowind < 0 || rowind >= tab.rows) {
			throw new ExceptionCalculation("row '" + rowind + " invalid for table " + tab.name, null);
		}
		if (!tab.shuffled) {
			return V.getInstance(tab.data[rowind * tab.cols + colind]);
		} else {
			return V.getInstance(tab.data[tab.oo[rowind] * tab.cols + colind]);
		}
	}

	public final static V findExact(Table tab, V... keys) {
		if (keys.length >= tab.cols) {
			throw new ExceptionCalculation("searched with too many keys in table " + tab.name, null);
		}
		int ind = findRow(tab, METHOD_EXACT_STRI, keys);
		if (ind < 0) {
			throw new ExceptionCalculation("did not find row in table " + tab.name + " with keys: "+Arrays.toString(keys), null);
		}
		return V.getInstance(tab.data[ind * tab.cols + keys.length]);
	}

	public final static V findExactColumn(Table tab, V columnname, V... keys) {
		String colname = columnname.stringValue();
		int colind = getColindex(tab, colname);
		if (colind < 0) {
			throw new ExceptionCalculation("column '" + colname + "' does not exist in table " + tab.name, null);
		}
		int ind = findRow(tab, METHOD_EXACT_STRI, keys);
		if (ind < 0) {
			throw new ExceptionCalculation("did not find row in table " + tab.name + " with keys: "+Arrays.toString(keys), null);
		}
		return V.getInstance(tab.data[ind * tab.cols + colind]);
	}

	public final static V findExactColumnIndex(Table tab, int colind, V... keys) {
		if (colind < 0 || colind >= tab.cols) {
			throw new ExceptionCalculation("column with index '" + colind + " does not exist in table " + tab.name, null);
		}
		int ind = findRow(tab, METHOD_EXACT_STRI, keys);
		if (ind < 0) {
			throw new ExceptionCalculation("did not find row in table " + tab.name + " with keys: "+Arrays.toString(keys), null);
		}
		return V.getInstance(tab.data[ind * tab.cols + colind]);
	}

	public final static V findIntervalUp(Table tab, V... keys) {
		if (keys.length >= tab.cols) {
			throw new ExceptionCalculation("searched with too many keys in table " + tab.name, null);
		}
		int ind = findRow(tab, METHOD_INTERVAL_UP, keys);
		if (ind < 0) {
			throw new ExceptionCalculation("did not find row in table " + tab.name + " with interval search (up) using search criteria: "+Arrays.toString(keys), null);
		}
		return V.getInstance(tab.data[ind * tab.cols + keys.length]);
	}

	public final static V findIntervalUpColumn(Table tab, V columnname,
			V... keys) {
		String colname = columnname.stringValue();
		int colind = getColindex(tab, colname);
		if (colind < 0) {
			throw new ExceptionCalculation("column '" + colname + "' does not exist in table " + tab.name, null);
		}
		int ind = findRow(tab, METHOD_INTERVAL_UP, keys);
		if (ind < 0) {
			throw new ExceptionCalculation("did not find row in table " + tab.name + " with interval search (up) with search criteria: "+Arrays.toString(keys), null);
		}
		return V.getInstance(tab.data[ind * tab.cols + colind]);
	}

	public final static V findIntervalDown(Table tab, V... keys) {
		if (keys.length >= tab.cols) {
			throw new ExceptionCalculation("searched with too many keys in table " + tab.name, null);
		}
		int ind = findRow(tab, METHOD_INTERVAL_DOWN, keys);
		if (ind < 0) {
			throw new ExceptionCalculation("did not find row in table " + tab.name + " with interval search (down) with search criteria: "+Arrays.toString(keys), null);
		}
		return V.getInstance(tab.data[ind * tab.cols + keys.length]);
	}

	public final static V findIntervalDownColumn(Table tab, V columnname,
			V... keys) {
		String colname = columnname.stringValue();
		int colind = getColindex(tab, colname);
		if (colind < 0) {
			throw new ExceptionCalculation("column '" + colname + "' does not exist in table " + tab.name, null);
		}
		int ind = findRow(tab, METHOD_INTERVAL_DOWN, keys);
		if (ind < 0) {
			throw new ExceptionCalculation("did not find row in table " + tab.name + " with interval search (down) with search criteria: "+Arrays.toString(keys), null);
		}
		return V.getInstance(tab.data[ind * tab.cols + colind]);
	}

	private final static double getDouble(String o) {
		return Double.parseDouble(o.toString());
	}

	private final static int compareNumerical(double val, String o) {
		double comp = Double.parseDouble(o.toString());
		return Double.compare(val, comp);
	}

	private final static int findRowDirect(Table tab, V key) {
		if (!key.isDouble()) {
			return -1;
		}
		double dval = key.doubleValue();
		int i = (int) dval;
		if (dval - (double) i != 0) {
			return -1;
		}
		int ind = i - tab.directaccessoffset;
		if (ind < 0 || ind >= tab.rows) {
			return -1;
		}
		String valstr = tab.data[ind * tab.cols];
		String keystr = key.stringValue();
		return valstr.equalsIgnoreCase(keystr) ? ind : -1;
	}

	private final static int findRow(Table tab, int method, final V... keys) {
		int keysLen = keys.length;
		if (tab.directaccess && keysLen == 1 && method == METHOD_EXACT_STRI) {
			return findRowDirect(tab, keys[0]);
		}
		String[] d = tab.data;
		TableColumn[] columns = tab.tablecolumnarr;
		if (keysLen == 0) {
			return -1;
		}
		String[] keysString = new String[keysLen];
		double[] keysDouble = new double[keysLen];
		for (int i = 0; i < keysLen; i++) {
			V key = keys[i];
			keysString[i] = key.stringValue();
			if (key.isDouble()) {
				keysDouble[i] = key.doubleValue();
			} else {
				/*
				 * if key cannot be converted to a double, but the column is
				 * numeric, the value can never be found
				 */
				if (columns[i].numeric) {
					return -1;
				}
			}
		}

		int cols = tab.cols;
		int rows = tab.rows;

		int low = 0;
		int high = rows - 1;
		int mid;
		int lenexact = keysLen;
		if (method != METHOD_EXACT_STRI) {
			lenexact--;
		}
		while (low <= high) {
			mid = (low + high) >>> 1;
			int indrowdata = mid * cols;
			int cmp = 0;
			/* exact comparison for first columns */
			for (int indcol = 0; indcol < lenexact; indcol++, indrowdata++) {
				String val = d[indrowdata];
				if (columns[indcol].numeric) {
					cmp = compareNumerical(keysDouble[indcol], val);
					if (cmp == 0) {
						cmp = keysString[indcol].compareToIgnoreCase(val);
					}
				} else {
					cmp = keysString[indcol]
					                 .compareToIgnoreCase(val.toString());
				}
				if (cmp != 0) {
					break;
				}
			}
			if (cmp == 0 && method != METHOD_EXACT_STRI) {
				/* interval comparison */
				String val = d[indrowdata];
				double dkey = keysDouble[lenexact];
				cmp = compareNumerical(dkey, val);
				/* lookup : value-in-row <= key < value-in-next-row */
				/* lookdown: value-in-row < key <= value-in-next-row */
				if (cmp > 0 || cmp == 0 && method == METHOD_INTERVAL_UP) {
					cmp = 0;
					/* compare with next row if there is one */
					if (mid + 1 < rows) {
						/* see if next column would fit as well */
						indrowdata = (mid + 1) * cols;
						for (int indcol = 0; indcol < lenexact; indcol++, indrowdata++) {
							val = d[indrowdata];
							if (columns[indcol].numeric) {
								cmp = compareNumerical(keysDouble[indcol], val);
								if (cmp == 0) {
									cmp = keysString[indcol]
									                 .compareToIgnoreCase(val.toString());
								}
							} else {
								cmp = keysString[indcol]
								                 .compareToIgnoreCase(val.toString());
							}
							if (cmp != 0) {
								break;
							}
						}
						/* next row does not fit -> we have it! */
						if (cmp != 0) {
							cmp = 0;
						} else {
							/* see if the interval-search-key fits for next row */
							String valnext = d[indrowdata];
							cmp = compareNumerical(dkey, valnext);
							if (cmp < 0 || cmp == 0
									&& method == METHOD_INTERVAL_DOWN) {
								cmp = 0;
							} else {
								cmp = 1; // continue search behind current row
							}
						}
					} else {
						cmp = 0;
					}
				} else {
					cmp = -1;
				}
			}
			if (cmp < 0) {
				high = mid - 1;
			} else if (cmp > 0) {
				low = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}

	/**
	 * ");
	 * 
	 * @param rownum
	 *            row index, starting with 1");
	 * @param colnum
	 *            column index, starting with 1");
	 */
	public final static V getCell(Table tab, V row, V col) {
		int rownum = (int) row.longValue();
		int colnum = (int) col.longValue();
		int cols = tab.cols;
		if (rownum < 1 || rownum > tab.rows || colnum < 1 || colnum > cols) {
			throw new ExceptionCalculation("invalid columnnumber " + colnum + " in table" + tab.name, null);
		}
		if (tab.shuffled) {
			return V.getInstance(tab.data[tab.oo[(rownum - 1)] * cols
			                              + colnum - 1]);
		} else {
			return V.getInstance(tab.data[(rownum - 1) * cols + colnum - 1]);
		}
	}

	public final static V getCellsRow(Table tab, V row, V colFrom, V colTo) {
		int rownum = (int) row.longValue();
		int colnumFrom = (int) colFrom.longValue();
		int colnumTo = (int) colTo.longValue();
		int cols = tab.cols;
		if (rownum < 1 || rownum > tab.rows || colnumFrom < 1
				|| colnumFrom > cols || colnumTo > cols) {
			throw new ExceptionCalculation("invalid column/rownumber in cell-access for table " + tab.name, null);
		}
		int len = colnumTo - colnumFrom + 1;
		if (len < 0) {
			len = 0;
		}
		V[] ret = new V[len];
		int ind = tab.shuffled ? (tab.oo[rownum - 1]) * cols + colnumFrom
				- 1 : (rownum - 1) * cols + colnumFrom - 1;
		for (int i = 0; i < len; i++, ind++) {
			ret[i] = V.getInstance(tab.data[ind]);
		}
		return V.getInstance(ret);
	}

	public final static V getCellsColumn(Table tab, V rowFrom, V rowTo, V col) {
		int rownumFrom = (int) rowFrom.longValue();
		int rownumTo = (int) rowTo.longValue();
		int colnum = (int) col.longValue();
		int cols = tab.cols;
		int rows = tab.rows;
		if (rownumFrom < 1 || rownumFrom > rows || rownumTo > rows
				|| colnum < 1 || colnum > cols) {
			throw new ExceptionCalculation("invalid column/rownumber in cell-access for table " + tab.name, null);
		}
		int len = rownumTo - rownumFrom + 1;
		if (len < 0) {
			len = 0;
		}
		String[] d = tab.data;
		V[] ret = new V[len];
		if (tab.shuffled) {
			int[] oo = tab.oo;
			int colind = colnum - 1;
			for (int i = 0, rowind = rownumFrom - 1; i < len; i++, rowind++) {
				int ind = oo[rowind] * cols + colind;
				ret[i] = V.getInstance(d[ind]);
			}
			return V.getInstance(ret);
		} else {
			int ind = (rownumFrom - 1) * cols + colnum - 1;
			for (int i = 0; i < len; i++, ind += cols) {
				ret[i] = V.getInstance(d[ind].toString());
			}
			return V.getInstance(ret);
		}
	}

	public final static V getCells(Table tab, V rowFrom, V rowTo, V colFrom,
			V colTo) {
		int rownumFrom = (int) rowFrom.longValue();
		int rownumTo = (int) rowTo.longValue();
		int colnumFrom = (int) colFrom.longValue();
		int colnumTo = (int) colTo.longValue();
		int cols = tab.cols;
		int rows = tab.rows;
		if (rownumFrom < 1 || rownumTo > rows || colnumFrom < 1
				|| colnumFrom > cols || colnumTo > cols) {
			throw new ExceptionCalculation("invalid column/rownumber in cell-access for table " + tab.name, null);
		}
		int lenRows = rownumTo - rownumFrom + 1;
		if (lenRows < 0) {
			lenRows = 0;
		}
		int lenCols = colnumTo - colnumFrom + 1;
		if (lenCols < 0) {
			lenCols = 0;
		}
		String[] d = tab.data;
		V[] ret = new V[lenRows];
		if (tab.shuffled) {
			int[] oo = tab.oo;
			for (int irow = 0; irow < lenRows; irow++) {
				int ind = oo[rownumFrom + irow - 1] * cols + colnumFrom - 1;
				V[] vrow = new V[lenCols];
				for (int icol = 0; icol < lenCols; icol++, ind++) {
					vrow[icol] = V.getInstance(d[ind]);
				}
				V retrow = V.getInstance(vrow);
				ret[irow] = retrow;
			}
			return V.getInstance(ret);
		} else {
			for (int irow = 0; irow < lenRows; irow++) {
				int ind;
				ind = (rownumFrom + irow - 1) * cols + colnumFrom - 1;
				V[] vrow = new V[lenCols];
				for (int icol = 0; icol < lenCols; icol++, ind++) {
					vrow[icol] = V.getInstance(d[ind]);
				}
				V retrow = V.getInstance(vrow);
				ret[irow] = retrow;
			}
			return V.getInstance(ret);
		}
	}

	public final static V getCellByName(Table tab, V row, V colname) {
		String coln = colname.stringValue();
		int colind = getColindex(tab, coln);
		return getCell(tab, row, V.getInstance(colind + 1));
	}

	public final static V getCellsRowByName(Table tab, V row, V colNameFrom,
			V colNameTo) {
		String colnFrom = colNameFrom.stringValue();
		String colnTo = colNameTo.stringValue();
		int colindFrom = getColindex(tab, colnFrom);
		int colindTo = getColindex(tab, colnTo);
		if (colindFrom < 0 || colindTo < 0) {
			throw new ExceptionCalculation("invalid column/rownumber in cell-access for table " + tab.name, null);
		}
		return getCellsRow(tab, row, V.getInstance(colindFrom + 1),
				V.getInstance(colindTo + 1));
	}

	public final static V getCellsColumnByName(Table tab, V rowFrom, V rowTo,
			V colname) {
		String coln = colname.stringValue();
		int colind = getColindex(tab, coln);
		return getCellsColumn(tab, rowFrom, rowTo, V.getInstance(colind + 1));
	}

	public final static V getCellsByName(Table tab, V rowFrom, V rowTo,
			V colNameFrom, V colNameTo) {
		String colnFrom = colNameFrom.stringValue();
		String colnTo = colNameTo.stringValue();
		int colindFrom = getColindex(tab, colnFrom);
		int colindTo = getColindex(tab, colnTo);
		if (colindFrom < 0 || colindTo < 0) {
			throw new ExceptionCalculation("invalid column/rownumber in cell-access for table " + tab.name, null);
		}
		return getCells(tab, rowFrom, rowTo, V.getInstance(colindFrom + 1),
				V.getInstance(colindTo + 1));
	}

	public final static V interpol(Table tab, V key) {
		int cols = tab.cols;
		int rows = tab.rows;
		String[] d = tab.data;
		if (cols < 2 || !tab.tablecolumnarr[0].numeric) {
			throw new ExceptionCalculation("did not find row in table " + tab.name + " access 'interpol' with key: "+key.stringValue(), null);
		} else {
			double dkey;
			if (key.isDouble()) {
				dkey = key.doubleValue();
			} else {
				throw new ExceptionCalculation("did not find row in table " + tab.name + " access 'interpol' with key: "+key.stringValue(), null);
			}
			/* do lookup-search with just one key */
			int low = 0;
			int high = 1;
			int mid;
			while (low <= high) {
				mid = (low + high) >>> 1;
				int indrowdata = mid * cols;
				/* interval comparison */
				String val = d[indrowdata];
				double drow1 = getDouble(val);
				int cmp = Double.compare(dkey, drow1);
				/* lookdown: value-in-row < key <= value-in-next-row */
				if (cmp >= 0) {
					if (mid >= rows - 1) {
						return cmp == 0 ? null : null; /*
						 * also when last entry
						 * found exactly -> same
						 * es notfound in VPMS!?
						 */
					}
					if (cmp == 0) { // found exactly
						double dval1 = getDouble(d[indrowdata + 1]);
						return V.getInstance(dval1);
					}
					/* see if next column would fit as well */
					int indrowdatanext = (mid + 1) * cols;
					String valnext = d[indrowdatanext];
					double drow2 = getDouble(valnext);
					cmp = Double.compare(dkey, drow2);
					if (cmp < 0) { // got it!
						double dval1 = getDouble(d[indrowdata + 1]);
						double dval2 = getDouble(d[indrowdatanext + 1]);
						double dresult = dval1 + (dkey - drow1)
						* (dval2 - dval1) / (drow2 - drow1);
						return V.getInstance(dresult);
					} else {
						cmp = 1; // continue search behind current row
					}
				}
				if (cmp < 0) {
					high = mid - 1;
				} else if (cmp > 0) {
					low = mid + 1;
				}
			}
			throw new ExceptionCalculation("did not find row in table " + tab.name + " access 'interpol' with key: "+key.stringValue(), null);
		}
	}
}
