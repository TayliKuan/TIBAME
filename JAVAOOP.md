# JAVA  物件導向概論
 NOTE JAVA 0225 - VII 章 物件導向概論  BY:Tayli

## 所見及物件
以手機為例
* 特徵(屬性)
特徵 : 紫色、5.5吋、IPHONE11、3萬
* 行為(功能)
可以打電話、可以上網、可以拍照

## Java透過類別(class)實現物件
* 重複使用/多人開發
* 思考以多人團隊大型專案來想
(你寫的程式碼 要給別人用 或是你要執行別人的程式碼)

**class 類別 - 告訴Java甚麼是螢幕 教java 先建立類別**
- 資料成員 特徵/屬性 (變數/常數)
- 方法成員 行為

## **→就像告訴JAVA 物件的規格書 設計圖**

舉例 電腦螢幕 設計圖
``````javascript=
public class Screen {
	double size;
	String color;
	int price;
	String brand;
	
	public void show() {
		System.out.println("顯示畫面");
        System.out.println("牌子為:"+brand);
	}
}
``````
:::success
**先有類別 才有物件:tada:**
:::
(先有設計圖 才可以做出實體東西)

實際案例
> Pen
> 設計圖
 ``````javascript=
public class Pen {
	//實體變數，需透過物件參考變數進行操作
	String brand;
	double price;
	//方法成員，需透過物件參考變數進行呼叫
	public void showInfo() {
		System.out.println("牌子為：" + brand);
		System.out.println("價格為：" + price);
	}
}
```````

> PenTest 
> 實際做出筆 new 跟 . 很重要!!!
``````javascript=
public class PenTest {

	public static void main(String[] args) {
		Pen myPen = new Pen();//第一次建立的時候一定要給它資料類型 所以他就是筆的類型
		myPen.brand = "SKB";
		myPen.price = 10;
		
		Pen yourPen = new Pen();//每個物件都有自己的特徵
		yourPen.brand = "MontBlanc";
		yourPen.price = 12000;
		
		myPen.showInfo();//呼叫裡面的方法
		yourPen.showInfo();
	}

}
``````

---

## 區域變數(方法變數) VS. 實體變數(屬性變數 成員變數)
### * 宣告
:::info
:zap:區域變數 → 宣告在方法裡面, 或是流程控制的區域裡面
:zap:實體變數 → 宣告在方法外, 類別裡面, 而且沒有static關鍵字
:::
程式碼範例
> Pen
```javascript=
public class Pen {
	String brand=10; //實體變數 必須宣告同時指定
      //double price; //這樣分開
      //price=10;     //不會過
      
	public void showInfo() {
		int i1; //區域變數 
                i = 10;
       //或是  int i1=10; 都可以
	}
}
```

### * 初始值
:::info
:zap:區域變數 → 沒有預設初始值, 存取之前, 程式設計師要主動給予初始值
:zap:實體變數 → 宣告後, Java會自動給予預設初始值, 根據資料型別有不同的初始值
:::
程式碼範例
> Pen
 ```javascript=
public class Pen {

	String brand;
	double price;
    
	
	public void showInfo() {
		int i1;
		System.out.println(i1);//區域變數 不會自動給值
		System.out.println("牌子為：" + brand);//實體變數 會自動給值 
		System.out.println("價格為：" + price);//實體變數 會自動給值
	}
}
```
> 個別執行結果
> i1>>> The local variable i1 may not have been initialized  //i1尚未初始化
> brand>>> null //因為String
> price>>> 0.0  //因為double

### * 存取
:::info
:zap:區域變數 → 只能在自己所宣告的區域內使用, 不能跨區直接使用
:zap:實體變數 → 只要在同個類別裡, 可以跨不同方法使用(該方法不可以有static關鍵字), 透過物件參考變數存取
:::
程式碼範例
> Pen
 ```javascript=
 public class Pen {
	String brand;
	double price;
	
	public void showInfo() {
		int i1;
		i1 = 10;
		System.out.println(i1);
		System.out.println("牌子為：" + brand);
		System.out.println("價格為：" + price);
	}
}
````
>  PenTest
 ```javascript=
public class PenTest {

	public static void main(String[] args) {
		Pen myPen = new Pen();
		myPen.brand = "SKB";
		myPen.price = 10;

		Pen yourPen = new Pen();
		yourPen.brand = "MontBlanc";
		yourPen.price = 12000;

		myPen.showInfo();
         yourPen.showInfo();
	}
}
````
執行結果
> 10
> 牌子為：SKB
> 價格為：10.0
> 10
> 牌子為：MontBlanc
> 價格為：12000.0

說明
> 這裡PenTest 不會看到 i1 這個資料 i1只存在 showInfo()內 只在區域內使用
> 但是brand、price是實體變數 可以 . 會看到這兩個變數 可以跨區使用


### * 生命週期(scope)

:::info
:zap:區域變數 → 如同名稱, 跟著自己所屬的區域或方法, 執行時存活, 當該區域或方法執行完畢, 此變數即被釋放
:zap:實體變數 → 如同名稱, 跟著所屬的物件實體創建而存在, 只要該物件實體還在, 此實體變數就會隨著物件存活著, 直到該物件消失才結束
:::
程式碼範例
> Pen
 ```javascript=
 public class Pen {
 int counter = 0;

	public void showInfo() {
		int countinside = 0;
		counter++;
		countinside++;
        System.out.println("counter 實體變數=" + counter);
		System.out.println("countinside 區域變數=" + countinside);
	}
}
 ```
> PenTest
  ```javascript=
  public class PenTest {

	public static void main(String[] args) {
		Pen myPen = new Pen();
          myPen.showInfo();//測試1
		System.out.println("=================");
		myPen.showInfo();//測試2
		System.out.println("=================");
		myPen.showInfo();//測試3
 ```
> 執行結果
> 
> counter 實體變數=1
> countinside 區域變數=1
> ================='
> counter 實體變數=2
> countinside 區域變數=1
> ================='
> counter 實體變數=3
> countinside 區域變數=1
> > 
> 說明
> 實體變數 跟著物件 myPen 一起
> 區域變數 執行這方法這區域的時候 才會來使用 做完就消失了 RESET


## 實作練習
請新建一個Student.java,並定義一個屬性為score,型別為int,
另定義兩個方法分別為play()與study(),功能如下:
- public void play(int hours)
每玩樂一個小時,score就會減1
- public void study(int hours)
每讀書一個小時,score就會加1
``````javascript=
public class Student {
int score = 90;

public void play (int hours) {
	
	score-=hours;//玩一小時 扣一分
	System.out.println("玩了"+hours+"小時");
}

public void study(int hours ) {
	
	score+=hours;//念書一小時 加一分
	System.out.println("念書"+hours+"小時");
}

public static void main(String[]args) {
	
	Student tayli=new Student();
	Student david = new Student();
    
    	//System.out.println(score);找不到score 因為Java不知道你在講誰的score
	System.out.println("初始分數"+tayli.score);
	System.out.println("初始分數"+david.score);
	System.out.println();
        //行為前大家都一樣
    
        //每個物件都有自己的特色
	tayli.play(5);
	tayli.study(3);

	System.out.println("Tayli 得分="+tayli.score);
	System.out.println();
	
	david.play(10);
	david.study(5);
	System.out.println("David得分="+david.score);
}
}
``````

執行結果

> 初始分數90
> 初始分數90
> 
> 玩了5小時
> 念書3小時
> Tayli 得分=88
> 
> 玩了10小時
> 念書5小時
> David得分=85
> 

---
# 在記憶體中儲存物件參考變數
- 物件參考變數儲存記憶體位址 (memory address)
- 基本資料型別變數儲存值 (value)
```javascript=
int i1 = 10;
int i2 = 0;
Pen myPen = new Pen();
Pen yourPen = new Pen();
```
![](https://i.imgur.com/BdgUbG5.png)

- 存的是門牌號碼
```javascript=
//下面再加一行
int i1 = 10;
int i2 = 0;
Pen myPen = new Pen();
Pen yourPen = new Pen();

i1 = i2;
```

![](https://i.imgur.com/UWbhbbG.png)
```javascript=
//下面再加一行
int i1 = 10;
int i2 = 0;
Pen myPen = new Pen();
Pen yourPen = new Pen();
i1 = i2;

myPen = yourPen;
```
![](https://i.imgur.com/x2qGa37.png)

## * 範例 傳值傳址測試
```javascript=

public class PassArgTest {
			    //double value = price;
	static void passValue(double value) {
		value = 20.0;
	}
	                        //Pen reference = myPen;
	static void passReference(Pen reference) {//要一個Pen的類型
		reference.price = 20.0;//用存的位置 找到
	}
	
	public static void main(String[] args) {
		double price = 10.0;
		passValue(price);//呼叫方法 把price傳到 passValue
		//copy一份值給passValue這個方法
		System.out.println(price); // 10 還是原本的資料 沒有因為方法的執行而被修改
		
		Pen myPen = new Pen();
		myPen.price = 10.0;
		passReference(myPen);//copy一個位置(門牌)給passReference這個方法
		System.out.println(myPen.price); // 20(原始資料發生修改 被passReference方法裡面被改掉了)
	}
}

```
![](https://i.imgur.com/OEKfMJE.png)
執行結果
> 10.0
> 20.0

***
**物件參考變數**

:::success
* 傳值 Pass by value
:::
如果傳入的參數為基本資料型別時,在方法內對參數的改變將不影響原來方法外變數的值
→ 因為傳值動作 可看作就是copy value
:::success
* 傳址 Pass by reference(物件的記憶體位置-門牌)
:::
如果傳入的參數為物件參考變數或陣列時,可更動reference對象原變數的值,也可使用reference對象的方法與變數
→ 因為傳參考讓方法也可以操作同一個物件實體，因此很容易發生資料被修改的情況
:::danger
  :mega: JAVA官方特別申明 只有Pass by value 
:::
**基本型別傳的是值的值，物件參考變數傳的是址的值
 所以全部都是值的傳遞!!!**:fire::fire::fire:

> 會有爭議是因為C++語言對reference這名詞定義有所誤解，才有爭議
> 此java reference 表示 門牌號碼 (記憶體位置) → 其實也是個值 ~END
> 
**物件導向程式語言OOP必定有三特性**
1. 封裝(Encapsulation)-依類別成員存取權限分為private, default, protected與public
2. 繼承(Inheritance)-子類別可繼承父類別的成員,並可以修改或是新增自有成員
3. 多型(Polymorphism)-父類別指向子類別物件,並對應到子類別適用的方法
OOP使用訊息傳遞(Message Passing)機制,透過物件接受訊息、處理
訊息、傳送訊息來實現功能