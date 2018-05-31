package cn.com.vector.play.contract;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple6;
import org.web3j.tuples.generated.Tuple7;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import rx.Observable;
import rx.functions.Func1;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.4.0.
 */
public class EggAuctionWar extends Contract {
    private static final String BINARY = "0x608060405260008060146101000a81548160ff021916908315150217905550678ac7230489e8000060075534801561003657600080fd5b506040516040806127d18339810180604052810190808051906020019092919080519060200190929190505050336000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555081600160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555080600260006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550505061269b806101366000396000f300608060405260043610610128576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff1680631646f3bf1461012d5780632be79833146101575780633070ddad146101ae5780633f4ba83a146102aa57806341177855146102c1578063451c3d80146103595780635c975abb146103b05780636016a9f4146103df57806378bd7935146104365780637aacf03c1461052b5780638456cb59146105565780638da5cb5b1461056d578063a0a9e9e1146105c4578063ae4f1198146105f1578063b8fc28811461061c578063c0e313411461065d578063ccfdec8c146106d7578063d7c069191461072e578063da76d5cd1461079a578063e05fe5c4146107c7578063edd963ac146107f4578063f2fde38b1461084b575b600080fd5b610155600480360381019080803590602001909291908035906020019092919050505061088e565b005b34801561016357600080fd5b5061016c610e47565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b3480156101ba57600080fd5b506101d960048036038101908080359060200190929190505050610e6d565b604051808881526020018773ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200180602001868152602001858152602001848152602001838152602001828103825287818151815260200191508051906020019080838360005b8381101561026957808201518184015260208101905061024e565b50505050905090810190601f1680156102965780820380516001836020036101000a031916815260200191505b509850505050505050505060405180910390f35b3480156102b657600080fd5b506102bf610f67565b005b3480156102cd57600080fd5b50610302600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050611025565b6040518080602001828103825283818151815260200191508051906020019060200280838360005b8381101561034557808201518184015260208101905061032a565b505050509050019250505060405180910390f35b34801561036557600080fd5b5061036e61116a565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b3480156103bc57600080fd5b506103c5611190565b604051808215151515815260200191505060405180910390f35b3480156103eb57600080fd5b50610434600480360381019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919080359060200190929190803590602001909291905050506111a3565b005b34801561044257600080fd5b5061046160048036038101908080359060200190929190505050611347565b604051808781526020018673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200180602001858152602001848152602001838152602001828103825286818151815260200191508051906020019080838360005b838110156104eb5780820151818401526020810190506104d0565b50505050905090810190601f1680156105185780820380516001836020036101000a031916815260200191505b5097505050505050505060405180910390f35b34801561053757600080fd5b50610540611453565b6040518082815260200191505060405180910390f35b34801561056257600080fd5b5061056b611459565b005b34801561057957600080fd5b50610582611519565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b3480156105d057600080fd5b506105ef6004803603810190808035906020019092919050505061153e565b005b3480156105fd57600080fd5b50610606611a4c565b6040518082815260200191505060405180910390f35b34801561062857600080fd5b5061064760048036038101908080359060200190929190505050611a52565b6040518082815260200191505060405180910390f35b6106d5600480360381019080803590602001909291908035906020019092919080359060200190929190803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290505050611a75565b005b3480156106e357600080fd5b50610718600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050611e81565b6040518082815260200191505060405180910390f35b34801561073a57600080fd5b50610743611e99565b6040518080602001828103825283818151815260200191508051906020019060200280838360005b8381101561078657808201518184015260208101905061076b565b505050509050019250505060405180910390f35b3480156107a657600080fd5b506107c560048036038101908080359060200190929190505050611ef1565b005b3480156107d357600080fd5b506107f260048036038101908080359060200190929190505050611fdd565b005b34801561080057600080fd5b50610835600480360381019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919050505061229b565b6040518082815260200191505060405180910390f35b34801561085757600080fd5b5061088c600480360381019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291905050506122e4565b005b60008060008060008060149054906101000a900460ff161515156108b157600080fd5b6004600088815260200190815260200160002060010160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1694503373ffffffffffffffffffffffffffffffffffffffff168573ffffffffffffffffffffffffffffffffffffffff161415151561092557600080fd5b60006004600089815260200190815260200160002060050154118015610961575085600460008981526020019081526020016000206005015410155b151561096c57600080fd5b3461099687600460008b8152602001908152602001600020600301546123b990919063ffffffff16565b1415156109a257600080fd5b3493506000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168573ffffffffffffffffffffffffffffffffffffffff16141515610a6e57610a0f6064856123ec90919063ffffffff16565b9250610a24838561240790919063ffffffff16565b91508473ffffffffffffffffffffffffffffffffffffffff166108fc839081150290604051600060405180830381858888f19350505050158015610a6c573d6000803e3d6000fd5b505b600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166323b872dd8633896040518463ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018281526020019350505050602060405180830381600087803b158015610b6757600080fd5b505af1158015610b7b573d6000803e3d6000fd5b505050506040513d6020811015610b9157600080fd5b81019080805190602001909291905050501515610bad57600080fd5b8560046000898152602001908152602001600020600501541415610ce857610bd487612420565b90506003600160038054905003815481101515610bed57fe5b9060005260206000200154600382815481101515610c0757fe5b90600052602060002001819055506003805480919060019003610c2a9190612556565b50600460008881526020019081526020016000206000808201600090556001820160006101000a81549073ffffffffffffffffffffffffffffffffffffffff0219169055600282016000610c7e9190612582565b60038201600090556004820160009055600582016000905560068201600090555050600560008673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060009055610dc1565b610d1186600460008a81526020019081526020016000206005015461240790919063ffffffff16565b6004600089815260200190815260200160002060050181905550610d7d86600560008873ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000205461240790919063ffffffff16565b600560008773ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020819055505b3373ffffffffffffffffffffffffffffffffffffffff168573ffffffffffffffffffffffffffffffffffffffff167fbcdc90478fd52c371057a4167fc1e7b3a5ee392c87f0c5b52be39545fdf5176689878a426040518085815260200184815260200183815260200182815260200194505050505060405180910390a350505050505050565b600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b60046020528060005260406000206000915090508060000154908060010160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1690806002018054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610f455780601f10610f1a57610100808354040283529160200191610f45565b820191906000526020600020905b815481529060010190602001808311610f2857829003601f168201915b5050505050908060030154908060040154908060050154908060060154905087565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515610fc257600080fd5b600060149054906101000a900460ff161515610fdd57600080fd5b60008060146101000a81548160ff0219169083151502179055507f7805862f689e2f13df9f062ff482ad3ad112aca9e0847911ed832e158c525b3360405160405180910390a1565b60606000606060008061103786612471565b9350836040519080825280602002602001820160405280156110685781602001602082028038833980820191505090505b50925060009050600091505b60038054905082101561115e578573ffffffffffffffffffffffffffffffffffffffff16600460006003858154811015156110ab57fe5b9060005260206000200154815260200190815260200160002060010160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1614156111515760038281548110151561111357fe5b9060005260206000200154838281518110151561112c57fe5b906020019060200201818152505061114e60018261253890919063ffffffff16565b90505b8180600101925050611074565b82945050505050919050565b600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b600060149054906101000a900460ff1681565b600060149054906101000a900460ff161515156111bf57600080fd5b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614151561121a57600080fd5b6000600860008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206001015411151561126b57600080fd5b600860008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600080820160006101000a81549073ffffffffffffffffffffffffffffffffffffffff02191690556001820160009055600282016000905550508273ffffffffffffffffffffffffffffffffffffffff167ff06d939e59bb907876936994dc10f43dfd19f20eeee14f45b43d9c544666ef3182844260405180848152602001838152602001828152602001935050505060405180910390a2505050565b6000806060600080600080600460008981526020019081526020016000209050806000015496508060010160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff169550806002018054600181600116156101000203166002900480601f01602080910402602001604051908101604052809291908181526020018280546001816001161561010002031660029004801561142d5780601f106114025761010080835404028352916020019161142d565b820191906000526020600020905b81548152906001019060200180831161141057829003601f168201915b505050505094508060030154935080600401549250806005015491505091939550919395565b60065481565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161415156114b457600080fd5b600060149054906101000a900460ff161515156114d057600080fd5b6001600060146101000a81548160ff0219169083151502179055507f6985a02210a168e66602d3235cb6db0e70f92b3ba4d376a33c0f3d9434bff62560405160405180910390a1565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b600060149054906101000a900460ff1615151561155a57600080fd5b6001811015151561156a57600080fd5b60018060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166370a08231336040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001915050602060405180830381600087803b15801561162857600080fd5b505af115801561163c573d6000803e3d6000fd5b505050506040513d602081101561165257600080fd5b8101908080519060200190929190505050101580156117b957506116be81600560003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000205461253890919063ffffffff16565b600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166370a08231336040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001915050602060405180830381600087803b15801561177b57600080fd5b505af115801561178f573d6000803e3d6000fd5b505050506040513d60208110156117a557600080fd5b810190808051906020019092919050505010155b15156117c457600080fd5b600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166323b872dd336000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff16846040518463ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018281526020019350505050602060405180830381600087803b1580156118de57600080fd5b505af11580156118f2573d6000803e3d6000fd5b505050506040513d602081101561190857600080fd5b8101908080519060200190929190505050151561192457600080fd5b6060604051908101604052803373ffffffffffffffffffffffffffffffffffffffff16815260200182815260200142815250600860003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008201518160000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555060208201518160010155604082015181600201559050503373ffffffffffffffffffffffffffffffffffffffff167f7aab8c0bd3d4afd47e471ac30c0c2df7e1cefe87cd3d42a5715341597b094d1c8242604051808381526020018281526020019250505060405180910390a250565b60075481565b600381815481101515611a6157fe5b906000526020600020016000915090505481565b60008060149054906101000a900460ff16151515611a9257600080fd5b600073ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614151515611ace57600080fd5b60018310151515611ade57600080fd5b600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166370a08231336040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001915050602060405180830381600087803b158015611b9b57600080fd5b505af1158015611baf573d6000803e3d6000fd5b505050506040513d6020811015611bc557600080fd5b8101908080519060200190929190505050611c28600560003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020548561253890919063ffffffff16565b11151515611c3557600080fd5b611c4b600160065461253890919063ffffffff16565b600681905550600654905060e0604051908101604052808281526020013373ffffffffffffffffffffffffffffffffffffffff16815260200183815260200186815260200185815260200184815260200142815250600460008381526020019081526020016000206000820151816000015560208201518160010160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506040820151816002019080519060200190611d209291906125ca565b50606082015181600301556080820151816004015560a0820151816005015560c082015181600601559050506003819080600181540180825580915050906001820390600052602060002001600090919290919091505550611dca83600560003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000205461253890919063ffffffff16565b600560003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020819055503373ffffffffffffffffffffffffffffffffffffffff167e09646912aaa7019ad837e57cc5c0613299c8432f5268d4450ab8673fe0fa038287878742604051808681526020018581526020018481526020018381526020018281526020019550505050505060405180910390a25050505050565b60056020528060005260406000206000915090505481565b60606003805480602002602001604051908101604052809291908181526020018280548015611ee757602002820191906000526020600020905b815481526020019060010190808311611ed3575b5050505050905090565b60008060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515611f4e57600080fd5b3073ffffffffffffffffffffffffffffffffffffffff1631905081811115611fd9576000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166108fc839081150290604051600060405180830381858888f19350505050158015611fd7573d6000803e3d6000fd5b505b5050565b60008060149054906101000a900460ff16151515611ffa57600080fd5b3373ffffffffffffffffffffffffffffffffffffffff166004600084815260200190815260200160002060010160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1614806120b657506000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16145b15156120c157600080fd5b6121296004600084815260200190815260200160002060050154600560003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000205461240790919063ffffffff16565b600560003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000208190555061217582612420565b9050600360016003805490500381548110151561218e57fe5b90600052602060002001546003828154811015156121a857fe5b906000526020600020018190555060038054809190600190036121cb9190612556565b50600460008381526020019081526020016000206000808201600090556001820160006101000a81549073ffffffffffffffffffffffffffffffffffffffff021916905560028201600061221f9190612582565b600382016000905560048201600090556005820160009055600682016000905550503373ffffffffffffffffffffffffffffffffffffffff167f6a3d5a07d548e27ae884a742682e9b929c0a0e4040990bc28c04637c5c0771048342604051808381526020018281526020019250505060405180910390a25050565b6000600560008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020549050919050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614151561233f57600080fd5b600073ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff161415156123b657806000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055505b50565b600080828402905060008414806123da57508284828115156123d757fe5b04145b15156123e257fe5b8091505092915050565b60008082848115156123fa57fe5b0490508091505092915050565b600082821115151561241557fe5b818303905092915050565b600080600090505b600380549050811015612468578260038281548110151561244557fe5b9060005260206000200154141561245b57612468565b8080600101915050612428565b80915050919050565b60008060008091505b60038054905082101561252e578373ffffffffffffffffffffffffffffffffffffffff16600460006003858154811015156124b157fe5b9060005260206000200154815260200190815260200160002060010160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1614156125215761251e60018261253890919063ffffffff16565b90505b818060010192505061247a565b8092505050919050565b600080828401905083811015151561254c57fe5b8091505092915050565b81548183558181111561257d5781836000526020600020918201910161257c919061264a565b5b505050565b50805460018160011615610100020316600290046000825580601f106125a857506125c7565b601f0160209004906000526020600020908101906125c6919061264a565b5b50565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061260b57805160ff1916838001178555612639565b82800160010185558215612639579182015b8281111561263857825182559160200191906001019061261d565b5b509050612646919061264a565b5090565b61266c91905b80821115612668576000816000905550600101612650565b5090565b905600a165627a7a723058200ce61c669232d2dd3cd5ea50cc8e43c20837a41704e31c12abda21e9dd3cf0920029";

    public static final String FUNC_CANCELEGGAUCTION = "cancelEggAuction";

    public static final String FUNC_CREATEEGGAUCTION = "createEggAuction";

    public static final String FUNC_EXECUTEEGGAUCTION = "executeEggAuction";

    public static final String FUNC_FINISHWAR = "finishWar";

    public static final String FUNC_JOINWAR = "joinWar";

    public static final String FUNC_PAUSE = "pause";

    public static final String FUNC_TRANSFEROWNERSHIP = "transferOwnership";

    public static final String FUNC_UNPAUSE = "unpause";

    public static final String FUNC_WITHDRAWBALANCE = "withdrawBalance";

    public static final String FUNC_ACCEPTEDTOKEN = "acceptedToken";

    public static final String FUNC_AUCTIONINDEX = "auctionIndex";

    public static final String FUNC_AUCTIONONWER = "auctionOnwer";

    public static final String FUNC_GETAUCTION = "getAuction";

    public static final String FUNC_GETAUCTIONS = "getAuctions";

    public static final String FUNC_GETAUCTIONSBYOWNER = "getAuctionsByOwner";

    public static final String FUNC_GETCOUNTBYOWNER = "getCountByOwner";

    public static final String FUNC_INDEXARR = "indexArr";

    public static final String FUNC_NONFUNGIBLEREGISTRY = "nonFungibleRegistry";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_OWNERCOUNT = "ownerCount";

    public static final String FUNC_PAUSED = "paused";

    public static final String FUNC_PUBLICATIONFEEINWEI = "publicationFeeInWei";

    public static final Event PAUSE_EVENT = new Event("Pause", 
            Arrays.<TypeReference<?>>asList(),
            Arrays.<TypeReference<?>>asList());
    ;

    public static final Event AUCTIONCANCELLED_EVENT = new Event("AuctionCancelled", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}),
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event AUCTIONSUCCESSFUL_EVENT = new Event("AuctionSuccessful", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}),
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event AUCTIONCREATED_EVENT = new Event("AuctionCreated", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}),
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event WAREXECUTED_EVENT = new Event("WarExecuted", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}),
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event WARCREATED_EVENT = new Event("WarCreated", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}),
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event UNPAUSE_EVENT = new Event("Unpause", 
            Arrays.<TypeReference<?>>asList(),
            Arrays.<TypeReference<?>>asList());
    ;

    protected EggAuctionWar(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected EggAuctionWar(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public RemoteCall<TransactionReceipt> cancelEggAuction(BigInteger _auctionId) {
        final Function function = new Function(
                FUNC_CANCELEGGAUCTION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_auctionId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> createEggAuction(BigInteger _price, BigInteger expiresAt, BigInteger _count, String _name, BigInteger weiValue) {
        final Function function = new Function(
                FUNC_CREATEEGGAUCTION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_price), 
                new org.web3j.abi.datatypes.generated.Uint256(expiresAt), 
                new org.web3j.abi.datatypes.generated.Uint256(_count), 
                new org.web3j.abi.datatypes.Utf8String(_name)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public List<PauseEventResponse> getPauseEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(PAUSE_EVENT, transactionReceipt);
        ArrayList<PauseEventResponse> responses = new ArrayList<PauseEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            PauseEventResponse typedResponse = new PauseEventResponse();
            typedResponse.log = eventValues.getLog();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<PauseEventResponse> pauseEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, PauseEventResponse>() {
            @Override
            public PauseEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(PAUSE_EVENT, log);
                PauseEventResponse typedResponse = new PauseEventResponse();
                typedResponse.log = log;
                return typedResponse;
            }
        });
    }

    public Observable<PauseEventResponse> pauseEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(PAUSE_EVENT));
        return pauseEventObservable(filter);
    }

    public List<AuctionCancelledEventResponse> getAuctionCancelledEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(AUCTIONCANCELLED_EVENT, transactionReceipt);
        ArrayList<AuctionCancelledEventResponse> responses = new ArrayList<AuctionCancelledEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            AuctionCancelledEventResponse typedResponse = new AuctionCancelledEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.seller = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.id = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.time = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<AuctionCancelledEventResponse> auctionCancelledEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, AuctionCancelledEventResponse>() {
            @Override
            public AuctionCancelledEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(AUCTIONCANCELLED_EVENT, log);
                AuctionCancelledEventResponse typedResponse = new AuctionCancelledEventResponse();
                typedResponse.log = log;
                typedResponse.seller = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.id = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.time = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<AuctionCancelledEventResponse> auctionCancelledEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(AUCTIONCANCELLED_EVENT));
        return auctionCancelledEventObservable(filter);
    }

    public List<AuctionSuccessfulEventResponse> getAuctionSuccessfulEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(AUCTIONSUCCESSFUL_EVENT, transactionReceipt);
        ArrayList<AuctionSuccessfulEventResponse> responses = new ArrayList<AuctionSuccessfulEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            AuctionSuccessfulEventResponse typedResponse = new AuctionSuccessfulEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.seller = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.winner = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.id = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.price = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.salesCount = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.time = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<AuctionSuccessfulEventResponse> auctionSuccessfulEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, AuctionSuccessfulEventResponse>() {
            @Override
            public AuctionSuccessfulEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(AUCTIONSUCCESSFUL_EVENT, log);
                AuctionSuccessfulEventResponse typedResponse = new AuctionSuccessfulEventResponse();
                typedResponse.log = log;
                typedResponse.seller = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.winner = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.id = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.price = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.salesCount = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
                typedResponse.time = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<AuctionSuccessfulEventResponse> auctionSuccessfulEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(AUCTIONSUCCESSFUL_EVENT));
        return auctionSuccessfulEventObservable(filter);
    }

    public List<AuctionCreatedEventResponse> getAuctionCreatedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(AUCTIONCREATED_EVENT, transactionReceipt);
        ArrayList<AuctionCreatedEventResponse> responses = new ArrayList<AuctionCreatedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            AuctionCreatedEventResponse typedResponse = new AuctionCreatedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.seller = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.id = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.price = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.expiresAt = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.salesCount = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
            typedResponse.time = (BigInteger) eventValues.getNonIndexedValues().get(4).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<AuctionCreatedEventResponse> auctionCreatedEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, AuctionCreatedEventResponse>() {
            @Override
            public AuctionCreatedEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(AUCTIONCREATED_EVENT, log);
                AuctionCreatedEventResponse typedResponse = new AuctionCreatedEventResponse();
                typedResponse.log = log;
                typedResponse.seller = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.id = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.price = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.expiresAt = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
                typedResponse.salesCount = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
                typedResponse.time = (BigInteger) eventValues.getNonIndexedValues().get(4).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<AuctionCreatedEventResponse> auctionCreatedEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(AUCTIONCREATED_EVENT));
        return auctionCreatedEventObservable(filter);
    }

    public List<WarExecutedEventResponse> getWarExecutedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(WAREXECUTED_EVENT, transactionReceipt);
        ArrayList<WarExecutedEventResponse> responses = new ArrayList<WarExecutedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            WarExecutedEventResponse typedResponse = new WarExecutedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.ower = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.cardTokenId = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.ddcCount = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.time = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<WarExecutedEventResponse> warExecutedEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, WarExecutedEventResponse>() {
            @Override
            public WarExecutedEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(WAREXECUTED_EVENT, log);
                WarExecutedEventResponse typedResponse = new WarExecutedEventResponse();
                typedResponse.log = log;
                typedResponse.ower = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.cardTokenId = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.ddcCount = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.time = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<WarExecutedEventResponse> warExecutedEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(WAREXECUTED_EVENT));
        return warExecutedEventObservable(filter);
    }

    public List<WarCreatedEventResponse> getWarCreatedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(WARCREATED_EVENT, transactionReceipt);
        ArrayList<WarCreatedEventResponse> responses = new ArrayList<WarCreatedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            WarCreatedEventResponse typedResponse = new WarCreatedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.ower = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.count = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.time = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<WarCreatedEventResponse> warCreatedEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, WarCreatedEventResponse>() {
            @Override
            public WarCreatedEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(WARCREATED_EVENT, log);
                WarCreatedEventResponse typedResponse = new WarCreatedEventResponse();
                typedResponse.log = log;
                typedResponse.ower = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.count = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.time = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<WarCreatedEventResponse> warCreatedEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(WARCREATED_EVENT));
        return warCreatedEventObservable(filter);
    }

    public RemoteCall<TransactionReceipt> executeEggAuction(BigInteger _auctionId, BigInteger _count, BigInteger weiValue) {
        final Function function = new Function(
                FUNC_EXECUTEEGGAUCTION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_auctionId), 
                new org.web3j.abi.datatypes.generated.Uint256(_count)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public List<UnpauseEventResponse> getUnpauseEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(UNPAUSE_EVENT, transactionReceipt);
        ArrayList<UnpauseEventResponse> responses = new ArrayList<UnpauseEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            UnpauseEventResponse typedResponse = new UnpauseEventResponse();
            typedResponse.log = eventValues.getLog();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<UnpauseEventResponse> unpauseEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, UnpauseEventResponse>() {
            @Override
            public UnpauseEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(UNPAUSE_EVENT, log);
                UnpauseEventResponse typedResponse = new UnpauseEventResponse();
                typedResponse.log = log;
                return typedResponse;
            }
        });
    }

    public Observable<UnpauseEventResponse> unpauseEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(UNPAUSE_EVENT));
        return unpauseEventObservable(filter);
    }

    public RemoteCall<TransactionReceipt> finishWar(String _to, BigInteger _count, BigInteger _cardTokenId) {
        final Function function = new Function(
                FUNC_FINISHWAR, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_to), 
                new org.web3j.abi.datatypes.generated.Uint256(_count), 
                new org.web3j.abi.datatypes.generated.Uint256(_cardTokenId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> joinWar(BigInteger _count) {
        final Function function = new Function(
                FUNC_JOINWAR, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_count)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> pause() {
        final Function function = new Function(
                FUNC_PAUSE, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> transferOwnership(String newOwner) {
        final Function function = new Function(
                FUNC_TRANSFEROWNERSHIP, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(newOwner)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public static RemoteCall<EggAuctionWar> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _acceptedToken, String _nonFungibleRegistry) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_acceptedToken), 
                new org.web3j.abi.datatypes.Address(_nonFungibleRegistry)));
        return deployRemoteCall(EggAuctionWar.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static RemoteCall<EggAuctionWar> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _acceptedToken, String _nonFungibleRegistry) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_acceptedToken), 
                new org.web3j.abi.datatypes.Address(_nonFungibleRegistry)));
        return deployRemoteCall(EggAuctionWar.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public RemoteCall<TransactionReceipt> unpause() {
        final Function function = new Function(
                FUNC_UNPAUSE, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> withdrawBalance(BigInteger amount) {
        final Function function = new Function(
                FUNC_WITHDRAWBALANCE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> acceptedToken() {
        final Function function = new Function(FUNC_ACCEPTEDTOKEN, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<BigInteger> auctionIndex() {
        final Function function = new Function(FUNC_AUCTIONINDEX, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<Tuple7<BigInteger, String, String, BigInteger, BigInteger, BigInteger, BigInteger>> auctionOnwer(BigInteger param0) {
        final Function function = new Function(FUNC_AUCTIONONWER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        return new RemoteCall<Tuple7<BigInteger, String, String, BigInteger, BigInteger, BigInteger, BigInteger>>(
                new Callable<Tuple7<BigInteger, String, String, BigInteger, BigInteger, BigInteger, BigInteger>>() {
                    @Override
                    public Tuple7<BigInteger, String, String, BigInteger, BigInteger, BigInteger, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple7<BigInteger, String, String, BigInteger, BigInteger, BigInteger, BigInteger>(
                                (BigInteger) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (String) results.get(2).getValue(), 
                                (BigInteger) results.get(3).getValue(), 
                                (BigInteger) results.get(4).getValue(), 
                                (BigInteger) results.get(5).getValue(), 
                                (BigInteger) results.get(6).getValue());
                    }
                });
    }

    public RemoteCall<Tuple6<BigInteger, String, String, BigInteger, BigInteger, BigInteger>> getAuction(BigInteger _id) {
        final Function function = new Function(FUNC_GETAUCTION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_id)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        return new RemoteCall<Tuple6<BigInteger, String, String, BigInteger, BigInteger, BigInteger>>(
                new Callable<Tuple6<BigInteger, String, String, BigInteger, BigInteger, BigInteger>>() {
                    @Override
                    public Tuple6<BigInteger, String, String, BigInteger, BigInteger, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple6<BigInteger, String, String, BigInteger, BigInteger, BigInteger>(
                                (BigInteger) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (String) results.get(2).getValue(), 
                                (BigInteger) results.get(3).getValue(), 
                                (BigInteger) results.get(4).getValue(), 
                                (BigInteger) results.get(5).getValue());
                    }
                });
    }

    public RemoteCall<List> getAuctions() {
        final Function function = new Function(FUNC_GETAUCTIONS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Uint256>>() {}));
        return new RemoteCall<List>(
                new Callable<List>() {
                    @Override
                    @SuppressWarnings("unchecked")
                    public List call() throws Exception {
                        List<Type> result = (List<Type>) executeCallSingleValueReturn(function, List.class);
                        return convertToNative(result);
                    }
                });
    }

    public RemoteCall<List> getAuctionsByOwner(String _owner) {
        final Function function = new Function(FUNC_GETAUCTIONSBYOWNER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_owner)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Uint256>>() {}));
        return new RemoteCall<List>(
                new Callable<List>() {
                    @Override
                    @SuppressWarnings("unchecked")
                    public List call() throws Exception {
                        List<Type> result = (List<Type>) executeCallSingleValueReturn(function, List.class);
                        return convertToNative(result);
                    }
                });
    }

    public RemoteCall<BigInteger> getCountByOwner(String _owner) {
        final Function function = new Function(FUNC_GETCOUNTBYOWNER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_owner)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> indexArr(BigInteger param0) {
        final Function function = new Function(FUNC_INDEXARR, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<String> nonFungibleRegistry() {
        final Function function = new Function(FUNC_NONFUNGIBLEREGISTRY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> owner() {
        final Function function = new Function(FUNC_OWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<BigInteger> ownerCount(String param0) {
        final Function function = new Function(FUNC_OWNERCOUNT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<Boolean> paused() {
        final Function function = new Function(FUNC_PAUSED, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<BigInteger> publicationFeeInWei() {
        final Function function = new Function(FUNC_PUBLICATIONFEEINWEI, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public static EggAuctionWar load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new EggAuctionWar(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static EggAuctionWar load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new EggAuctionWar(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static class PauseEventResponse {
        public Log log;
    }

    public static class AuctionCancelledEventResponse {
        public Log log;

        public String seller;

        public BigInteger id;

        public BigInteger time;
    }

    public static class AuctionSuccessfulEventResponse {
        public Log log;

        public String seller;

        public String winner;

        public BigInteger id;

        public BigInteger price;

        public BigInteger salesCount;

        public BigInteger time;
    }

    public static class AuctionCreatedEventResponse {
        public Log log;

        public String seller;

        public BigInteger id;

        public BigInteger price;

        public BigInteger expiresAt;

        public BigInteger salesCount;

        public BigInteger time;
    }

    public static class WarExecutedEventResponse {
        public Log log;

        public String ower;

        public BigInteger cardTokenId;

        public BigInteger ddcCount;

        public BigInteger time;
    }

    public static class WarCreatedEventResponse {
        public Log log;

        public String ower;

        public BigInteger count;

        public BigInteger time;
    }

    public static class UnpauseEventResponse {
        public Log log;
    }
}
