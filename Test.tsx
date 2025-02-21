

const abc = () => {
    const array1: Array<string> = ['a', 'b', 'c'];

    //convert array to set and vice versa
    const set = new Set(array1);
    const array2 = [...set];
    //convert set to object
    const objSet: { [key: string]: string } = Object.fromEntries(set.entries());

    //convert array to Map and vice versa
    const map: Map<string, string> = new Map(array1.map((item: string) => [item, item.toLocaleUpperCase()]));
    const array3: Array<string> = Array.from(map.values());
    const array4: Array<string> = Array.from(map.keys());
    const array5: Array<[string, string]> = Array.from(map)

    //convert array to object and vice versa
    const obj1: { [key: string]: string } = Object.fromEntries(array1.map((item: string) => [item, item.toLocaleUpperCase()]));
    const array6: Array<string> = [...Object.keys(obj1)];
    const array7: Array<[string, string]> = Object.entries(obj1);
    const array8: Array<string> = [...Object.values(obj1)];


    const obj2: { [key: string]: string | number } = { name: 'Alice', age: 25, country: 'USA' };

    //convert object to Map and vice versa
    const map1: Map<string, string | number> = new Map(Object.entries(obj2));
    const obj3: { [key: string]: string | number } = Object.fromEntries(map1);


}