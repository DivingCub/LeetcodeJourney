class RandomizedSet {
  list: Array<number>;
  map: object;

  constructor() {
    this.list = [];
    this.map = {};
  }

  insert(val: number): boolean {
    if (val in this.map) {
      return false;
    }
    this.list.push(val);
    this.map[val] = this.list.length - 1; // ->索引
    return true;
  }

  remove(val: number): boolean {
    if (val in this.map) {
      // 找到要删除的元素的索引
      const index = this.map[val];
      let last = this.list[this.list.length - 1];
      // 将尾部元素放到 要删除的元素的位置
      this.list[index] = last;
      this.map[last] = index;
      // 删掉尾元素
      delete this.map[val];
      this.list.pop();
      return true;
    }
    return false;
  }

  getRandom(): number {
    const i = Math.floor(Math.random() * this.list.length);
    return this.list[i];
  }
}