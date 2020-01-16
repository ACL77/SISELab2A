class Counter {
        private int cnt = 0;
        public Counter(int init) {
            cnt = init;
        }
        public void  increment() {
            cnt++;
        }
        public  void  decrement() {
            cnt--;
        }
        public int  value() {
            return cnt;
        }
    }
