public class MaxBinaryHeap {
    private Event[] maxHeap;
    private int noOfNode;

    public MaxBinaryHeap() {
        maxHeap = new Event[10];
        noOfNode = 0;
    }

    public void insert(Event event) {
        if (noOfNode == maxHeap.length) {
            Event[] newMaxHeap = new Event[maxHeap.length * 2];
            System.arraycopy(maxHeap, 0, newMaxHeap, 0, maxHeap.length);
            newMaxHeap[maxHeap.length] = event;
            maxHeap = newMaxHeap;
            noOfNode++;
            bubbleUpByDate(maxHeap.length - 1);
            bubbleUpByTime(maxHeap.length - 1);
        } else if (noOfNode < maxHeap.length) {
            maxHeap[noOfNode] = event;
            noOfNode++;
            bubbleUpByDate(noOfNode - 1);
            bubbleUpByTime(noOfNode - 1);
        }

    }

    public Event removeLast() {
        if (noOfNode == 0) {
            throw new RuntimeException("The heap is empty"); // throw error
        } else if (noOfNode > 0) {
            Event lastNode = maxHeap[noOfNode - 1];
            noOfNode--;
            return lastNode;
        }
        return null;

    }

    public Event remove(Event event) {
        if (noOfNode == 0) {
            throw new RuntimeException("The heap is empty");

        } else if (noOfNode > 0) {
            int lastIndex = noOfNode - 1;
            for (int i = 0; i < maxHeap.length; i++) {
                if (maxHeap[i].equals(event)) {

                    int remove = i;

                    swap(i, lastIndex);
                    removeLast();

                    bubbleDownByDate(i);
                    bubbleDownByTime(i);

                    bubbleUpByDate(i);
                    bubbleUpByTime(i);

                    return maxHeap[remove];
                }

            }
        }
        return null;

    }

    private void bubbleUpByDate(int index) {
        while (index > 0) {
            int parentInd = (index - 1) / 2;
            if ((maxHeap[parentInd].getDate() < maxHeap[index].getDate())) {
                swap(parentInd, index);
                index = parentInd;
            } else {
                break;
            }
        }
    }

    private void bubbleUpByTime(int index) {
        while (index > 0) {
            int parentInd = (index - 1) / 2;
            if ((maxHeap[parentInd].getTime() < maxHeap[index].getTime())) {
                swap(parentInd, index);
                index = parentInd;
            } else {
                break;
            }
        }
    }

    private void swap(int i, int j) {
        Event temp = maxHeap[i];

        maxHeap[i] = maxHeap[j];
        maxHeap[j] = temp;
    }

    public String[] listOfNodes() {
        String[] list = new String[maxHeap.length];
        for (int i = 0; i < maxHeap.length; i++) {
            list[i] = maxHeap[i].toString();
        }
        return list;
    }

    private void bubbleDownByDate(int index) {
        while (true) {
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = 2 * index + 2;
            int largestIndex = index;

            if (leftChildIndex < maxHeap.length
                    && (maxHeap[leftChildIndex].getDate() > maxHeap[largestIndex].getDate())) {
                largestIndex = leftChildIndex;
            }

            if (rightChildIndex < maxHeap.length
                    && (maxHeap[rightChildIndex].getDate() > maxHeap[largestIndex].getDate())) {
                largestIndex = rightChildIndex;
            }

            if (largestIndex != index) {
                swap(index, largestIndex);
                index = largestIndex;
            } else {
                break;
            }
        }
    }

    private void bubbleDownByTime(int index) {
        while (true) {
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = 2 * index + 2;
            int largestIndex = index;

            if (leftChildIndex < maxHeap.length
                    && (maxHeap[leftChildIndex].getTime() > maxHeap[largestIndex].getTime())) {
                largestIndex = leftChildIndex;
            }

            if (rightChildIndex < maxHeap.length
                    && (maxHeap[rightChildIndex].getTime() > maxHeap[largestIndex].getTime())) {
                largestIndex = rightChildIndex;
            }

            if (largestIndex != index) {
                swap(index, largestIndex);
                index = largestIndex;
            } else {
                break;
            }
        }
    }

}
