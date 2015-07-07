package jp.classmethod.aws.sample.lambda;

import java.nio.charset.Charset;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.common.io.BaseEncoding;


public class Base64Encoder implements RequestHandler<String, String> {

	private static final Charset UTF_8 = Charset.forName("UTF-8");

	@Override
	public String handleRequest(String input, Context context) {
		LambdaLogger logger = context.getLogger();
		logger.log("input = " + input);
		String output = BaseEncoding.base64().encode(input.getBytes(UTF_8));
		logger.log("output = " + output);
		return output;
	}
}
