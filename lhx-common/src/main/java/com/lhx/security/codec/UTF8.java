package com.lhx.security.codec;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;

public class UTF8 {
	
	private static final Charset charSet = Charset.forName("UTF-8");
	
	public static byte[] encode(String srcStr){
		try {
			ByteBuffer byteBuf = charSet.newEncoder().encode(CharBuffer.wrap(srcStr));
			byte[] bytesCopy = new byte[byteBuf.limit()];
			System.arraycopy(byteBuf.array(), 0, bytesCopy, 0, byteBuf.limit());
			return bytesCopy;
		} catch (CharacterCodingException ex) {
			throw new IllegalArgumentException(srcStr+" encode failed! ",ex);
		}
	}
	
	public static String decode(byte[] srcBytes){
		try {
			return charSet.newDecoder().decode(ByteBuffer.wrap(srcBytes)).toString();
		} catch (CharacterCodingException ex) {
			throw new IllegalArgumentException(" decode failed! ",ex);
		}
	}

}
