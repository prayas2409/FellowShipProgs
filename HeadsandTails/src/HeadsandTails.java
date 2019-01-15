import java.util.Random;

public class HeadsandTails {
	/**
	 * mHead counts number of times head was the result and similar with tail
	 * random is random number between 0-1. 
	 */
	int mHead=0,mTail=0;
	float mRandom=0;
	
	//genrates random number less than 1
	float generateRandom() {
		Random r1=new Random();
	
		float d= (float)r1.nextDouble();
		return d;
	}
	//int num is the number of times times the coin was flipped
	int random(int num) {
		//counter counts 0 to num
		int counter=0;
		float val=(float) 0.5;
		while(counter<num){
			
			mRandom=generateRandom();
			
			if(mRandom>val){ 
				mHead++;
			}
			else { mTail++;
			}	
			counter++;
		}
		//
		counter=(int)(((float)mHead/counter)*100);
		System.out.println("The Percent of head is "+counter+"and the percent of tails is "+(100-counter));

		return counter;	
	}
}
