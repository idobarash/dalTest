package com.cooladata.dal.base.util;

import java.util.Random;

public class CharUtils {
	
	private static char[] letters = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z',
		'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
		'0','1','2','3','4','5','6','7','8','9'};
	
	private static char[] lowercaseLetters = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
		'0','1','2','3','4','5','6','7','8','9'};

	
	public static char nextAvailableLetter(char letter){
		if (letter < 48)
			return 65;
		if (letter == 90)
			return 97;
		if (letter == 122)
			return 48;
		if (letter == 57)
			return 161;
		return ++letter;
	}
	
	public static char nextAvailableLetter(int letter){
		if (letter < letters.length)
			return letters[letter];
		return (char)(letter+99);
	}
	
	
	public static String generateUUID(int length){
		StringBuilder builder = new StringBuilder();
		Random rand = new Random();
		for (int i=0;i<length;i++)
			builder.append(letters[rand.nextInt(letters.length)]);
		return builder.toString();
	}
	
	public static String generateLowercaseUUID(int length){
		StringBuilder builder = new StringBuilder();
		Random rand = new Random();
		for (int i=0;i<length;i++)
			builder.append(lowercaseLetters[rand.nextInt(lowercaseLetters.length)]);
		return builder.toString();
	}

	public static String zeroPad(int num){
		if (num < 10)
			return "0"+num;
		return ""+num;
	}
	
	public static void main(String[] args) {
		int[] ids = {3557,3558,3559,3560,3561,3562,3563,3564,3565,3566,3567,3568,3569,3570,3571,3572,3573,3574,3575,3576,3577,3578,3579,3580,3581,3582,3583,3584,3585,3586,3587,3588,3589,3590,3591,3592,3593,3594,3595,3596,3597,3598,3599,3600,3601,3602,3603,3604,3605,3606,3607,3608,3609,3610,3611,3612,3613,3614,3615,3616,3617,3618,3619,3620,3621,3622,3623,3624,3625,3626,3627,3628,3629,3630,3631,3632,3633,3634,3635,3636,3637,3638,3639,3640,3641,3642,3643,3644,3645,3646,3647,3648,3649,3650,3651,3652,3653,3654,3655,3656,3657,3658,3659,3660,3661,3662,3663,3664,3665,3666,3667,3668,3669,3670,3671,3672,3673,3674,3675,3676,3677,3678,3679,3680,3681,3682,3683,3684,3685,3686,3687,3688,3689,3690,3691,3692,3693,3694,3695,3696,3697,3698,3699,3700,3701,3702,3703,3704,3705,3706,3707,3708,3709,3710,3711,3712,3713,3714,3715,3716,3717,3718};
		System.out.println(letters.length);
		
		/**
		 * #SELECT * FROM dal.event where projectId=113971 order by letter desc, id desc;
		#SELECT count(*) FROM dal.event where projectId=113971; 927
		#SELECT count(id) FROM dal.event where projectId=113971 and id > 3556 order by id;
		#SELECT count(*) FROM dal.event where projectId=113971 and id < 3556 order by id;
		#select letter from dal.event where id=3666
		#SELECT * FROM dal.event where projectId=113971 and id > 3556 order by id;
		#select letter l, count(letter) c from dal.event where projectId=113971 group by l having c>1
		 */
		char a =0;
		for (int i=0;i<162;i++){
			//System.out.println("new imp "+nextAvailableLetter(i));
			a=nextAvailableLetter(a);
			
			//System.out.println(ids[i]+" : "+ a);
			//System.out.println("update dal.event set letter = '"+a+"' where id = "+ids[i]+";");
		}
	}
	
//	public static void setLetterInEvent(Event event,char charofHighestEventInProject)
//	{
//		char c = CharUtils.nextAvailableLetter(charofHighestEventInProject);
//		event.setLetter(c);
//
//	}
//	
//	public static void setLetterInEventCategory(EventCategory eventCategory,char charofHighestEventInProject)
//	{
//		char c = CharUtils.nextAvailableLetter(charofHighestEventInProject);
//		eventCategory.setLetter(c);
//	}
	
}