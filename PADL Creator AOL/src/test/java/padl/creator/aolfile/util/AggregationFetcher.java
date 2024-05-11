/*******************************************************************************
 * Copyright (c) 2001-2014 Yann-Gaël Guéhéneuc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * 
 * Contributors:
 *     Yann-Gaël Guéhéneuc and others, see in file; API and its implementation
 ******************************************************************************/
package padl.creator.aolfile.util;

import java.io.File;
import padl.analysis.UnsupportedSourceModelException;
import padl.analysis.repository.AACRelationshipsAnalysis;
import padl.creator.aolfile.AOLCreator;
import padl.creator.aolfile.invocations.MethodInvocationAnalyser;
import padl.kernel.ICodeLevelModel;
import padl.kernel.IIdiomLevelModel;
import padl.kernel.exception.CreationException;
import padl.kernel.impl.Factory;
import util.io.ProxyConsole;


/**
 * @author Yann-Gaël Guéhéneuc
 * @since  2006/11/28
 */
public class AggregationFetcher {
	public static void main(final String[] args) {
		AggregationFetcher aggregationFetcher = new AggregationFetcher();
		aggregationFetcher.analyse("D:/Temp/Sodalia/Method Invocations/");
	}
	private void analyse(final String aPath) {
		final File pathFile = new File(aPath);
		final String[] subPaths = pathFile.list();

		for (int i = 0; i < subPaths.length; i++) {
			final String fileName = aPath + subPaths[i];
			final File file = new File(fileName);

			if (file.isDirectory()) {
				this.analyse(fileName + '/');
			}
			else if (fileName.indexOf("-concat_des_") > 0
					&& !fileName.endsWith(".filtered.aol")) {

				final String name =
					fileName.substring(fileName.lastIndexOf('/') + 1, fileName
						.indexOf('-'));
				final String cldFileName =
					fileName.replaceAll("concat_", "").replaceAll(
						".aol",
						".cld");

				try {
					System.out.print("Analysing ");
					System.out.print(name);
					System.out.println("...");

					ICodeLevelModel codeLevelModel =
						Factory.getInstance().createCodeLevelModel(name);
					codeLevelModel.create(new AOLCreator(
						new String[] { fileName }));

					final MethodInvocationAnalyser methodInvocationAdder =
						new MethodInvocationAnalyser();
					methodInvocationAdder.setCLDFile(cldFileName);
					codeLevelModel =
						(ICodeLevelModel) methodInvocationAdder
							.invoke(codeLevelModel);

					final IIdiomLevelModel idiomLevelModel =
						(IIdiomLevelModel) new AACRelationshipsAnalysis(false)
							.invoke(codeLevelModel);

					idiomLevelModel.walk(new AggregationVisitor(
						"D:/Temp/Sodalia/Method Invocations/" + name
								+ ".aggregations.txt"));
				}
				catch (final CreationException e) {
					e.printStackTrace(ProxyConsole.getInstance().errorOutput());
				}
				catch (final UnsupportedSourceModelException e) {
					e.printStackTrace(ProxyConsole.getInstance().errorOutput());
				}
			}
		}
	}
}

//	final AOLCreator aolCreator =
//		new AOLCreator(new String[] { "rsc/Mozilla/moz-1.0.rel.n.aol" });
//	final AOLCreator aolCreator =
//		new AOLCreator(
//			new String[] { "rsc/Firefox/AddBookmark_subset1.aol" });
//	final AOLCreator aolCreator =
//		new AOLCreator(new String[] { "rsc/Firefox/AddBookmark.aol" });
//	final AOLCreator aolCreator =
//		new AOLCreator(new String[] { "rsc/mozilla-1.0-concat_des_2006-02-15114305.aol" });
//	final AOLCreator aolCreator =
//		new AOLCreator(
//			new String[] { "C:/Temp/Giulio's AOL/IMS/code/IMS_2.5.1/Admin_2.3.3/Admin_2.3.3.N.aol" });
//	final AOLCreator aolCreator =
//		new AOLCreator(
//			new String[] { "C:/Temp/Giulio's AOL/IMS/code/IMS_2.5.1/DB_2.1.2/DB_2.1.2.N.aol" });
//	final AOLCreator aolCreator =
//		new AOLCreator(
//			new String[] { "C:/Temp/Giulio's AOL/IMS/code/IMS_2.5.1/ED_2.1.0/ED_2.1.0.N.aol" });
//	final AOLCreator aolCreator =
//		new AOLCreator(
//			new String[] { "C:/Temp/Giulio's AOL/IMS/code/IMS_2.5.1/HDOgui_2.4.6/HDOgui_2.4.6.N.aol" });
//	final AOLCreator aolCreator =
//		new AOLCreator(
//			new String[] { "C:/Temp/Giulio's AOL/IMS/code/IMS_2.5.1/Meta_2.1.0/Meta_2.1.0.N.aol" });
//	final AOLCreator aolCreator =
//		new AOLCreator(
//			new String[] { "C:/Temp/Giulio's AOL/IMS/code/IMS_2.5.1/NMI_2.2.0/NMI_2.2.0.N.aol" });
//	final AOLCreator aolCreator =
//		new AOLCreator(
//			new String[] { "C:/Temp/Giulio's AOL/IMS/code/IMS_2.5.1/OSSI_2.0.2/OSSI_2.0.2.N.aol" });
//	final AOLCreator aolCreator =
//		new AOLCreator(
//			new String[] { "C:/Temp/Giulio's AOL/IMS/code/IMS_2.5.1/PM_2.0.3/PM_2.0.3.N.aol" });
//	final AOLCreator aolCreator =
//		new AOLCreator(
//			new String[] { "C:/Temp/Giulio's AOL/IMS/code/IMS_2.5.1/TM_2.2.0/TM_2.2.0.N.aol" });
//	final AOLCreator aolCreator =
//		new AOLCreator(
//			new String[] { "C:/Temp/Giulio's AOL/IMS/design/ADM/ADM.aol" });
//	final AOLCreator aolCreator =
//		new AOLCreator(
//			new String[] { "C:/Temp/Giulio's AOL/REUSE/code/AlarmBrowser.aol.raw" });
//	final AOLCreator aolCreator =
//		new AOLCreator(
//			new String[] { "C:/Temp/Giulio's AOL/REUSE/code/LOGLIB.aol.raw" });
//	final AOLCreator aolCreator =
//		new AOLCreator(
//			new String[] { "C:/Temp/Giulio's AOL/VBS/code/DbConn.aol.raw" });
//	final AOLCreator aolCreator =
//		new AOLCreator(
//			new String[] { "C:/Temp/Giulio's AOL/VBS/code/DistPublic.aol.raw" });
//	final AOLCreator aolCreator =
//		new AOLCreator(
//			new String[] { "C:/Temp/Giulio's AOL/VBS/code/Error_Library.aol.raw" });
//	final AOLCreator aolCreator =
//		new AOLCreator(
//			new String[] { "C:/Temp/Giulio's AOL/VBS/code/GUIBrowser.aol.raw" });
//	final AOLCreator aolCreator =
//		new AOLCreator(
//			new String[] { "C:/Temp/Giulio's AOL/VBS/code/GUIconfig.aol.raw" });
//	final AOLCreator aolCreator =
//		new AOLCreator(
//			new String[] { "C:/Temp/Giulio's AOL/VBS/code/GUIevents.aol.raw" });
//	final AOLCreator aolCreator =
//		new AOLCreator(
//			new String[] { "C:/Temp/Giulio's AOL/VBS/code/Trace_Lib.aol.raw" });
//	final AOLCreator aolCreator =
//		new AOLCreator(
//			new String[] { "C:/Temp/Giulio's AOL/VBS/code/VIPER_PROCESSING.aol.raw" });
//	final AOLCreator aolCreator =
//		new AOLCreator(
//			new String[] { "C:/Temp/Giulio's AOL/VBS/code/VMCS_Processing.aol.raw" });
//	final AOLCreator aolCreator =
//		new AOLCreator(
//			new String[] { "C:/Temp/Giulio's AOL/VBS/code/VSPA_Processing.aol.raw" });
//	final AOLCreator aolCreator =
//		new AOLCreator(
//			new String[] { "C:/Temp/Giulio's AOL/VSPS/code/CollectorAcquisition.aol.raw" });
//	final AOLCreator aolCreator =
//		new AOLCreator(
//			new String[] { "C:/Temp/Giulio's AOL/VSPS/code/CollectorDistribution.aol.raw" });
//	final AOLCreator aolCreator =
//		new AOLCreator(
//			new String[] { "C:/Temp/Giulio's AOL/VSPS/code/CollectorFormatting.aol.raw" });
//	final AOLCreator aolCreator =
//		new AOLCreator(
//			new String[] { "C:/Temp/Giulio's AOL/VSPS/code/DispatcherDistribution.aol.raw" });
//	final AOLCreator aolCreator =
//		new AOLCreator(
//			new String[] { "C:/Temp/Giulio's AOL/VSPS/code/VP_FM_Filter.aol.raw" });
