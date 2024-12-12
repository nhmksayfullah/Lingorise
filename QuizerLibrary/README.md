# Quizer
Quiz Making Library.
This Library is in development sector. Don't use it in your serious project. it can have bug and a very few features.


Step 1. Add the JitPack repository to your build file

```gradle
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  ```
  
  Step 2. Add the dependency
  
  ```gradle
  dependencies {
	        implementation 'com.github.nhmkSAIFULLAH:Quizer:1.0.1'
	}
  ```
  
  Step 3. Design Your XML file with a TextView for showing Question and add 4 Textview of Button for Quiz option.
  
  Example:
  ```
  TextView tvQuestion, tvOption1, tvOption2, tvOption3, tvOption4;
  ```
  
  Step 4. Declare and initialize Quizer from your java class and pass your activity context with it.
  
  ```   
  Quizer quizer = new Quizer(getApplicationContext());
  
  ```
  
  Step 5. Create a list for your Quiz. add as much Quiz as you want.
  
  Example:
  
  ```   
  List<Quiz> myQuiz = new ArrayList<>();
        myQuiz.add(new Quiz("what is the meaning of 1","1","2","3","4","1"));
        myQuiz.add(new Quiz("what is the meaning of 1","1","2","3","4","2"));
        myQuiz.add(new Quiz("what is the meaning of 1","1","2","3","4","3"));
        myQuiz.add(new Quiz("what is the meaning of 1","1","2","3","4","4"));
        
  ```
  
  1st paramiter of the quiz is Question,
  
  2nd paramiter of the quiz is Option 1,
  
  3rd paramiter of the quiz is Option 2,
  
  4th paramiter of the quiz is Option 3,
  
  5th paramiter of the quiz is Option 4,
  
  6th paramiter of the quiz is Correct Answer.
  
  Step 6. Pass the Quiz List myQuiz and main Element of Textview or Button for Question and Option view.
  
 ```
  quizer.setQuizList(myQuiz);
  quizer.setPrimaryElement(tvQuestion, tvOption1, tvOption2, tvOption3, tvOption4);
  
 ```
 Step 7. Create the Quiz by call create() method.
 
 ```
 quizer.create();
 ```
 
 You can do it by one line.
 
 Example:
 
 ```
 Quizer quizer = new Quizer(getApplicationContext()).setQuizList(myQuiz).setPrimaryElement(tvQuestion, tvOption1, tvOption2, tvOption3, tvOption4).create();
 
 ```
