import java.util.*;

public class DemoArrayList {
	
	public static void main(String[] args) {
		
		int[] nums = new int[5];
		nums[0] = 8;
		nums[1] = 2;
		nums[2] = 3;
		nums[3] = 72;
		nums[4] = 7;
		
		for (int i = 0; i < nums.length; i++) 
			System.out.println(nums[i]);
		
		// swap the 2nd and 4th items
		int temp = nums[1];
		nums[1] = nums[3];
		nums[3] = temp;
		

		
		SmileyFace[] smileys = new SmileyFace[5];
		smileys[0] = new SmileyFace(10, 12, 10, null);
		smileys[1] = new SmileyFace(50, 60, 20, null);
		smileys[2] = new SmileyFace(20, 35, 130, null);
		smileys[3] = new SmileyFace(45, 75, 17, null);
		smileys[4] = new SmileyFace(100, 15, 20, null);
		
		for (int i = 0; i < smileys.length; i++) 
			System.out.println(smileys[i]);
		
		
		// Another way to do arrays - ArrayList
		
		ArrayList<Integer> nums1 = new ArrayList<Integer>();
		
		nums1.add(105);
		nums1.add(107);
		nums1.add(103);
		nums1.add(34);
		nums1.add(113);
		nums1.add(117);

		// insert the number 53 as the 3rd item
		nums1.add(2, 53);
		
		for (int i = 0; i < nums1.size(); i++) {
			System.out.println(nums1.get(i));
		}
		
		// swap 2nd and 4th items
		int temp1 = nums1.get(1);
		nums1.set(1, nums1.get(3));
		nums1.set(3, temp1);
		
		
		
		
		ArrayList<SmileyFace> smileys1 = new ArrayList<SmileyFace>();
		System.out.println(smileys1.size());
		
		smileys1.add(new SmileyFace(12, 13, 30, null));
		smileys1.add(new SmileyFace(14, 13, 30, null));
		smileys1.add(new SmileyFace(15, 13, 30, null));
		smileys1.add(new SmileyFace(16, 13, 30, null));
		smileys1.add(new SmileyFace(17, 13, 30, null));
		
		for (int i = 0; i < smileys1.size(); i++) {
			System.out.println(smileys1.get(i));
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
