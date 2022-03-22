import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Scanner;

/**
    A class of stacks whose entries are stored in an array.
    @author Frank M. Carrano and Timothy M. Henry
    @version 5.0
*/
public final class ArrayStack<T> implements StackInterface<T>
{
	private T[] stack;    // Array of stack entries
	private int topIndex; // Index of top entry
   private boolean integrityOK = false;
	private static final int DEFAULT_CAPACITY = 50;
	private static final int MAX_CAPACITY = 10000;
  
   public ArrayStack()
   {
      this(DEFAULT_CAPACITY);
   } // end default constructor
  
   public ArrayStack(int initialCapacity)
   {
      integrityOK = false;
     // checkCapacity(initialCapacity);
      
      // The cast is safe because the new array contains null entries
      @SuppressWarnings("unchecked")
      T[] tempStack = (T[])new Object[initialCapacity];
      stack = tempStack;
		topIndex = -1;
      integrityOK = true;
  } // end constructor
  
//  < Implementations of the stack operations go here. >
//  < Implementations of the private methods go here; checkCapacity and checkIntegrity
//    are analogous to those in Chapter 2. >
//  . . .
   
   public void push(int i)
   {
	  // checkIntegrity();  
	   ensureCapacity();
	   stack[topIndex + 1] = i;
	   topIndex++;
   }
   
   private void ensureCapacity()
   {
	   if (topIndex == stack.length - 1)
	   {
		   int newLength = 2 * stack.length;
		  // checkCapacity(newLenght);
		   stack = Arrays.copyOf(stack, newLength);
	   }
   }
   
   public T peek()
   {
     
	   if (isEmpty())
	   throw new EmptyStackException();
	   else
	   return stack[topIndex];
   }
   
  
   public T pop()
   {
     
	   if (isEmpty())
		   throw new EmptyStackException();
	   else
		   {
		   T top = stack[topIndex];
		   stack[topIndex] = null;
		   topIndex--;
	   return top;
		   } 
	   }
   
   public boolean isEmpty()
   {
	   return topIndex < 0;
   }
   public void clear() 
   {
	   if (isEmpty())
		   throw new EmptyStackException();
	   else
	   {
		   stack[topIndex] = null;
	   }
   }
   
     
   // implement the eveluatePostfix
   
   public static String evaluatePostfix( String postfix)
   {
	  
	   // new empty stack
	   ArrayStack<String> valueStack = new ArrayStack<>();
	   int count=0;
	   int operandTwo;
	   int operandOne;
	   int result;
	   while (!postfix.isEmpty())
	   {
		   char nextCharacter=postfix.charAt(count);
		   
		   switch(nextCharacter)
		   {
			    case '^':
				   valueStack.push(nextCharacter);
			         break;
			     case '0':
		             valueStack.push(nextCharacter);
		             break;
		         case '1':
		             valueStack.push(nextCharacter);
		             break;
		         case '2':
		             valueStack.push(nextCharacter);

		             break;
		         case '3':
		             valueStack.push(nextCharacter);

		             break;
		         case '4':
		             valueStack.push(nextCharacter);
		             break;
		         case '5':
		             valueStack.push(nextCharacter);
		             break;
		         case '6':
		             valueStack.push(nextCharacter);
		             break; 
		         case '7':
		             valueStack.push(nextCharacter);
		             break;
		         case '8':
		             valueStack.push(nextCharacter);
		             break;
		         case '9':
		             valueStack.push(nextCharacter);
		             break;				   
				   
			   case '+': 
					operandTwo= Integer.parseInt(valueStack.pop().toString());
					operandOne=Integer.parseInt(valueStack.pop().toString());
					result= operandOne+operandTwo;
					valueStack.push(result);
	           break;
	           
			   case '*': 
				    operandTwo= Integer.parseInt(valueStack.pop().toString());
					operandOne=Integer.parseInt(valueStack.pop().toString());
					result= operandOne*operandTwo;
					valueStack.push(result);
			   break;
			   
			   case '-': 
				    operandTwo= Integer.parseInt(valueStack.pop().toString());
					operandOne=Integer.parseInt(valueStack.pop().toString());
					result= operandOne-operandTwo;
					valueStack.push(result);
			   break;
			   
			   case '/': 
				    operandTwo= Integer.parseInt(valueStack.pop().toString());
					operandOne=Integer.parseInt(valueStack.pop().toString());
					result= operandOne/operandTwo;
					valueStack.push(result);
			   break;
			   default: break;
			   
			   }
		   
			   
		   
	   }
	   return valueStack.peek();
   }
 
   //
   
   
   //Test
   
   public static String convertToPostfix(String infix)
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
  
   // TEST//
	
	
	public static void main (String[] args)
	{
		String example = "a*b/(c-a)+d*e";
		String postfixRestul= convertToPostfix(example);
		System.out.println(postfixRestul);
		
		//
		//int evaluation= evaluatePostfix(postfixRestul);
		//System.out.println(evaluation);
		
		
	}
} // end ArrayStack
