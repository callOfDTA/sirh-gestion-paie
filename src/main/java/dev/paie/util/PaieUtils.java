package dev.paie.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class PaieUtils {
	
	public String formaterBigDecimal(BigDecimal decimal) {
		DecimalFormat df = new DecimalFormat();
		// forcer le séparateur "." même sur un poste en français
		df.setDecimalFormatSymbols(DecimalFormatSymbols.getInstance(Locale.UK));
		df.setMaximumFractionDigits(2);
		df.setRoundingMode(RoundingMode.UP);
		df.setMinimumFractionDigits(2);
		df.setGroupingUsed(false);
		return df.format(decimal);
		}


}
