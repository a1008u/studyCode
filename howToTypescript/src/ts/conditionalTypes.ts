

type Name = {name: string};
type Id = {id:number};
type Check = {enabled: boolean};

type LabelForType<T> =
    T extends string ? Name :
        T extends number ? Id :
            T extends boolean ? Check :
                never;


class ConditionalTypes {

}
