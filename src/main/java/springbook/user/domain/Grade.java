package springbook.user.domain;

public class Grade {
		int snumber;
		String name;
		int korean;
		int english;
		int math;
		int sum;
		float avr;
		String grade;
		int rank;
		
		public Grade(){}       
		 
        public Grade(int snumber, String name, int korean, int english, int math){
               this.snumber = snumber;
               this.name = name;
               this.korean = korean;
               this.english = english;
               this.math = math;
        }

		public int getSnumber() {
			return snumber;
		}

		public void setSnumber(int snumber) {
			this.snumber = snumber;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getKorean() {
			return korean;
		}

		public void setKorean(int korean) {
			this.korean = korean;
		}

		public int getEnglish() {
			return english;
		}

		public void setEnglish(int english) {
			this.english = english;
		}

		public int getMath() {
			return math;
		}

		public void setMath(int math) {
			this.math = math;
		}

		public int getSum() {
			return sum;
		}

		public void setSum(int sum) {
			this.sum = sum;
		}

		public float getAvr() {
			return avr;
		}

		public void setAvr(float avr) {
			this.avr = avr;
		}

		public String getGrade() {
			return grade;
		}

		public void setGrade(String grade) {
			this.grade = grade;
		}

		public int getRank() {
			return rank;
		}

		public void setRank(int rank) {
			this.rank = rank;
		}
        
        
}
