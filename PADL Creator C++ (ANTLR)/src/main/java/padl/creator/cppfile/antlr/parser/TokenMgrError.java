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
/* Generated By:JavaCC: Do not edit this line. TokenMgrError.java Version 3.0 */
package padl.creator.cppfile.antlr.parser;

public class TokenMgrError extends Error {
	/*
	 * Ordinals for various reasons why an Error of this type can be thrown.
	 */

	/**
	 * 
	 */
	private static final long serialVersionUID = -4567940338915266345L;

	/**
	    * Lexical error occured.
	    */
	static final int LEXICAL_ERROR = 0;

	/**
	 * An attempt wass made to create a second instance of a static token manager.
	 */
	static final int STATIC_LEXER_ERROR = 1;

	/**
	 * Tried to change to an invalid lexical state.
	 */
	static final int INVALID_LEXICAL_STATE = 2;

	/**
	 * Detected (and bailed out of) an infinite loop in the token manager.
	 */
	static final int LOOP_DETECTED = 3;

	/**
	 * Replaces unprintable characters by their espaced (or unicode escaped)
	 * equivalents in the given string
	 */
	protected static final String addEscapes(final String str) {
		final StringBuffer retval = new StringBuffer();
		char ch;
		for (int i = 0; i < str.length(); i++) {
			switch (str.charAt(i)) {
				case 0 :
					continue;
				case '\b' :
					retval.append("\\b");
					continue;
				case '\t' :
					retval.append("\\t");
					continue;
				case '\n' :
					retval.append("\\n");
					continue;
				case '\f' :
					retval.append("\\f");
					continue;
				case '\r' :
					retval.append("\\r");
					continue;
				case '\"' :
					retval.append("\\\"");
					continue;
				case '\'' :
					retval.append("\\\'");
					continue;
				case '\\' :
					retval.append("\\\\");
					continue;
				default :
					if ((ch = str.charAt(i)) < 0x20 || ch > 0x7e) {
						final String s = "0000" + Integer.toString(ch, 16);
						retval.append("\\u"
								+ s.substring(s.length() - 4, s.length()));
					}
					else {
						retval.append(ch);
					}
					continue;
			}
		}
		return retval.toString();
	}

	/**
	 * Returns a detailed message for the Error when it is thrown by the
	 * token manager to indicate a lexical error.
	 * Parameters : 
	 *    EOFSeen     : indicates if EOF caused the lexicl error
	 *    curLexState : lexical state in which this error occured
	 *    errorLine   : line number when the error occured
	 *    errorColumn : column number when the error occured
	 *    errorAfter  : prefix that was seen before this error occured
	 *    curchar     : the offending character
	 * Note: You can customize the lexical error message by modifying this method.
	 */
	protected static String LexicalError(
		final boolean EOFSeen,
		final int lexState,
		final int errorLine,
		final int errorColumn,
		final String errorAfter,
		final char curChar) {
		return "Lexical error at line "
				+ errorLine
				+ ", column "
				+ errorColumn
				+ ".  Encountered: "
				+ (EOFSeen ? "<EOF> " : "\""
						+ TokenMgrError.addEscapes(String.valueOf(curChar))
						+ "\"" + " (" + (int) curChar + "), ") + "after : \""
				+ TokenMgrError.addEscapes(errorAfter) + "\"";
	}

	/**
	 * Indicates the reason why the exception is thrown. It will have
	 * one of the above 4 values.
	 */
	int errorCode;

	public TokenMgrError() {
	}

	/*
	 * Constructors of various flavors follow.
	 */

	public TokenMgrError(
		final boolean EOFSeen,
		final int lexState,
		final int errorLine,
		final int errorColumn,
		final String errorAfter,
		final char curChar,
		final int reason) {
		this(TokenMgrError.LexicalError(
			EOFSeen,
			lexState,
			errorLine,
			errorColumn,
			errorAfter,
			curChar), reason);
	}

	public TokenMgrError(final String message, final int reason) {
		super(message);
		this.errorCode = reason;
	}

	/**
	 * You can also modify the body of this method to customize your error messages.
	 * For example, cases like LOOP_DETECTED and INVALID_LEXICAL_STATE are not
	 * of end-users concern, so you can return something like : 
	 *
	 *     "Internal Error : Please file a bug report .... "
	 *
	 * from this method for such cases in the release version of your parser.
	 */
	public String getMessage() {
		return super.getMessage();
	}
}
