


public class convertToPostfix {
	public static String convertToPostfix1(String infix)
	{
	
		//new stack
		ArrayStack<Character> operatorStack = new ArrayStack<>();
		int count=0;
		String postfix = new String("");
		while (count<infix.length())
		{
			char nextCharacter = infix.charAt(count);
			switch (nextCharacter)
				{
			case '^':
				operatorStack.push(nextCharacter);
				break;
			case'+':
			case'-':
			case'*':
			case'/':
				while (!operatorStack.isEmpty()&&getPrecedence(nextCharacter)<=getPrecedence(operatorStack.peek()))
					{
					postfix += operatorStack.pop();
					}
				operatorStack.push(nextCharacter);
				break;
			case '(':
				operatorStack.push(nextCharacter);
				break;
			case ')':
				
			while(operatorStack.isEmpty()&&operatorStack.peek()!='(')
			postfix +=nextCharacter;
			break;
				}
			++count;
		}
		
		while (!operatorStack.isEmpty()) 
		{
			postfix += operatorStack.pop();
		}
	return postfix;
	}

	private static int getPrecedence(Character chart) {
		// TODO Auto-generated method stub
		
		switch(chart)
		{
		case '^':
			return 3;
		case '/':
		case '*':
			return 2;
		case '+':
		case '-':
			return 1;
		}
		return -1;
	}
	
	
	//TEST//
	public static void main (String[] args)
	{
		String example = "a*b/(c-a)+d*e";
		String postfixRestul= convertToPostfix1(example);
		System.out.println(postfixRestul);
		
		
	
		
	}
} // end ArrayStack
	

