class Scratch {
    public static void main(String[] args) {
        int[] arr={ 3,1,2,4,0,2,3,2};
        System.out.println(waterTrappingCapacity(arr));
    }
   static int waterTrappingCapacity(int heights[]){
        int size=heights.length;
        int[] left=new int[size];
        int[] right=new int[size];
        left[0]=heights[0];
        right[size-1]=heights[size-1];
        int totalCapacity=0;
        for (int i = 1; i < heights.length; i++) {
            left[i]=Math.max(left[i-1],heights[i]);
        }

        for (int i = size-2; i >=0; i--) {
            right[i]=Math.max(right[i+1],heights[i]);
        }
        for (int i = 0; i < size; i++) {
            totalCapacity+=Math.min(left[i],right[i])-heights[i];
        }
        return totalCapacity;
    }
}