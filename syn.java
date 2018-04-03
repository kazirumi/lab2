package compiler2;

import java.util.Scanner;
import java.util.Stack;

import javax.print.DocFlavor.INPUT_STREAM;


public class Start {

	public static void main(String[] args) {
				Scanner sc =new Scanner(System.in);
				int count = 0;
				
				String equation = "x*y*z";
				String x;
				String y;
				String z;
				
				System.out.println("The mathematic Equation is:");
				System.out.print(equation);
				
				System.out.println("\nEnter the values of the variables:");
				x=sc.nextLine();
				y=sc.nextLine();
				z=sc.nextLine();
				System.out.println("the values of the variables are:" +x+ " "+y+ " "+z);
				
				
				if(equation.contains("xx") || equation.contains("yy") || equation.contains("zz") || equation.contains("xy") || equation.contains("yx") 
						|| equation.contains("xz") || equation.contains("zx") || equation.contains("yz") || equation.contains("zy") 
						|| equation.contains("++") || equation.contains("--") || equation.contains("**") || equation.contains("//") 
						|| equation.contains("+-") || equation.contains("+*") || equation.contains("+/") || equation.contains("-+")
						|| equation.contains("-*") || equation.contains("-/") || equation.contains("*+") || equation.contains("*-")
						|| equation.contains("*/") || equation.contains("/+") || equation.contains("/-") || equation.contains("/*")) {
					count ++;
				}
		
				if(count!=0) {
					System.out.println("The mathematic Equation is invalid");
					return;
				}
				else 
					System.out.println("The mathematic Equation is valid");
				
				equation = equation.replaceAll("x", x);
				equation = equation.replaceAll("y", y);
				equation = equation.replaceAll("z",z);
				
				System.out.println(equation);
				PostfixEval(equation);
				
				
		}
			
			static String input;
			static void PostfixEval(String iString) {
				String output = "";
				Stack stack = new Stack();
				input = iString;
				boolean bul = false;
	            for(int i = 0;i < input.length();i++){
	                    char curChar = input.charAt(i);
	                    if(!isOperator(curChar)){
	                            output += Character.toString(curChar);
	                            if(i == (input.length()-1)){
	                                    while(!stack.empty()){
	                                            output += stack.pop();
	                                    }
	                            }
	                    }else{
	                            if(bul){
	                                    if(pMin(curChar) && pMin((Character)stack.peek())){
	                                            output += stack.pop();
	                                            stack.push(curChar);
	                                            if(i == (input.length()-1)){
	                                                    while(!stack.empty()){
	                                                            output += stack.pop();
	                                                    }
	                                            }
	                                    }else if(mDiv(curChar) && mDiv((Character)stack.peek())){
	                                            output += stack.pop();
	                                            stack.push(curChar);
	                                            if(i == (input.length()-1)){
	                                                    while(!stack.empty()){
	                                                            output += stack.pop();
	                                                    }
	                                            }
	                                    }else if(pMin(curChar) && mDiv((Character)stack.peek())){
	                                            output += stack.pop();
	                                            stack.push(curChar);
	                                            if(i == (input.length()-1)){
	                                                    while(!stack.empty()){
	                                                            output += stack.pop();
	                                                    }
	                                            }
	                                    }else if(mDiv(curChar) && pMin((Character)stack.peek())){
	                                    	stack.push(curChar);
	                                            if(i == (input.length()-1)){
	                                                    while(!stack.empty()){
	                                                            output += stack.pop();
	                                                    }
	                                            }
	                                    }else{
	                                            output += Character.toString(curChar);
	                                            if(i == (input.length()-1)){
	                                                    while(!stack.empty()){
	                                                            output += stack.pop();
	                                                    }
	                                            }
	                                    }
	                            }else{
	                            	stack.push(curChar);
	                            	bul = true;
	                            }
	                    }
	            }
	            System.out.println("the postfix evalution is:" +output);
	            
	            int num1;
	            int num2;
	            int result=0;
	            //char temp2;
	            Stack<Integer> stack2 = new Stack<Integer>();
	            for(int j = 0; j<output.length() ; j++) {
	            	char temp = output.charAt(j);
	            	if (!"+".equals(temp) && !"*".equals(temp) && !"-".equals(temp) && !"/".equals(temp)) {
	            		stack2.push((int)(temp));
	            	}
	            	else {
						//temp2 = output.charAt(j);
						num2 = stack2.pop();
		                num1 = stack2.pop();
		                if ("/".equals(temp)){
		                    result = num1 / num2;
		                }
		                else if("*".equals(temp)){
		                    result = num1 * num2;
		                }
		                else if("+".equals(temp)){
		                    result = num1 + num2;
		                }
		                else if("-".equals(temp)){
		                    result = num1 - num2;
		                }
		                else 
		                	System.out.println("Illeagal symbol");
		                stack2.push(result);
					}
	            	//stack2.push(result);
	            	
	            }
	            stack2.pop();
	            System.out.println("Postfix Evauation = " + result);
			}
			
		static boolean isOperator(char op){
	            switch(op){
	                    case '+':
	                            return true;
	                    case '-':
	                            return true;
	                    case '/':
	                            return true;
	                    case '*':
	                            return true;
	                    case '^':
	                            return true;
	                    default:
	                            return false;
	            }
	    }

	    static boolean pMin(char op){
	            switch(op){
	                    case '+':
	                            return true;
	                    case '-':
	                            return true;
	                    default:
	                            return false;
	            }
	    }

	    static boolean mDiv(char op){
	            switch(op){
	                    case '*':
	                            return true;
	                    case '/':
	                            return true;
	                    default:
	                            return false;
	            }
	    }
}

