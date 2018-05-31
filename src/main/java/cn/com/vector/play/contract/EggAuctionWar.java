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
import org.web3j.tuples.generated.Tuple3;
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
    private static final String BINARY = "0x608060405260008060146101000a81548160ff021916908315150217905550670de0b6b3a764000060075534801561003657600080fd5b506040516040806129198339810180604052810190808051906020019092919080519060200190929190505050336000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555081600160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555080600260006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050506127e3806101366000396000f300608060405260043610610133576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff1680631646f3bf146101385780632be79833146101625780633070ddad146101b957806331b910b0146102b55780633f4ba83a14610346578063411778551461035d578063451c3d80146103f55780635c975abb1461044c5780636016a9f41461047b57806378bd7935146104d25780637aacf03c146105c75780638456cb59146105f25780638da5cb5b14610609578063a0a9e9e114610660578063ae4f11981461068d578063b8fc2881146106b8578063c0e31341146106f9578063ccfdec8c14610773578063d7c06919146107ca578063da76d5cd14610836578063e05fe5c414610863578063edd963ac14610890578063f2fde38b146108e7575b600080fd5b610160600480360381019080803590602001909291908035906020019092919050505061092a565b005b34801561016e57600080fd5b50610177610ef7565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b3480156101c557600080fd5b506101e460048036038101908080359060200190929190505050610f1d565b604051808881526020018773ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200180602001868152602001858152602001848152602001838152602001828103825287818151815260200191508051906020019080838360005b83811015610274578082015181840152602081019050610259565b50505050905090810190601f1680156102a15780820380516001836020036101000a031916815260200191505b509850505050505050505060405180910390f35b3480156102c157600080fd5b506102f6600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050611017565b604051808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001838152602001828152602001935050505060405180910390f35b34801561035257600080fd5b5061035b61109b565b005b34801561036957600080fd5b5061039e600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050611159565b6040518080602001828103825283818151815260200191508051906020019060200280838360005b838110156103e15780820151818401526020810190506103c6565b505050509050019250505060405180910390f35b34801561040157600080fd5b5061040a61129e565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b34801561045857600080fd5b506104616112c4565b604051808215151515815260200191505060405180910390f35b34801561048757600080fd5b506104d0600480360381019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919080359060200190929190803590602001909291905050506112d7565b005b3480156104de57600080fd5b506104fd6004803603810190808035906020019092919050505061147b565b604051808781526020018673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200180602001858152602001848152602001838152602001828103825286818151815260200191508051906020019080838360005b8381101561058757808201518184015260208101905061056c565b50505050905090810190601f1680156105b45780820380516001836020036101000a031916815260200191505b5097505050505050505060405180910390f35b3480156105d357600080fd5b506105dc611587565b6040518082815260200191505060405180910390f35b3480156105fe57600080fd5b5061060761158d565b005b34801561061557600080fd5b5061061e61164d565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b34801561066c57600080fd5b5061068b60048036038101908080359060200190929190505050611672565b005b34801561069957600080fd5b506106a2611b94565b6040518082815260200191505060405180910390f35b3480156106c457600080fd5b506106e360048036038101908080359060200190929190505050611b9a565b6040518082815260200191505060405180910390f35b610771600480360381019080803590602001909291908035906020019092919080359060200190929190803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290505050611bbd565b005b34801561077f57600080fd5b506107b4600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050611fc9565b6040518082815260200191505060405180910390f35b3480156107d657600080fd5b506107df611fe1565b6040518080602001828103825283818151815260200191508051906020019060200280838360005b83811015610822578082015181840152602081019050610807565b505050509050019250505060405180910390f35b34801561084257600080fd5b5061086160048036038101908080359060200190929190505050612039565b005b34801561086f57600080fd5b5061088e60048036038101908080359060200190929190505050612125565b005b34801561089c57600080fd5b506108d1600480360381019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291905050506123e3565b6040518082815260200191505060405180910390f35b3480156108f357600080fd5b50610928600480360381019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919050505061242c565b005b60008060008060008060149054906101000a900460ff1615151561094d57600080fd5b6004600088815260200190815260200160002060010160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1694503373ffffffffffffffffffffffffffffffffffffffff168573ffffffffffffffffffffffffffffffffffffffff16141515156109c157600080fd5b600060046000898152602001908152602001600020600501541180156109fd575085600460008981526020019081526020016000206005015410155b1515610a0857600080fd5b34610a3287600460008b81526020019081526020016000206003015461250190919063ffffffff16565b141515610a3e57600080fd5b3493506000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168573ffffffffffffffffffffffffffffffffffffffff16141515610b0a57610aab60648561253490919063ffffffff16565b9250610ac0838561254f90919063ffffffff16565b91508473ffffffffffffffffffffffffffffffffffffffff166108fc839081150290604051600060405180830381858888f19350505050158015610b08573d6000803e3d6000fd5b505b600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166323b872dd8633610b5f6007548b61250190919063ffffffff16565b6040518463ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018281526020019350505050602060405180830381600087803b158015610c1757600080fd5b505af1158015610c2b573d6000803e3d6000fd5b505050506040513d6020811015610c4157600080fd5b81019080805190602001909291905050501515610c5d57600080fd5b8560046000898152602001908152602001600020600501541415610d9857610c8487612568565b90506003600160038054905003815481101515610c9d57fe5b9060005260206000200154600382815481101515610cb757fe5b90600052602060002001819055506003805480919060019003610cda919061269e565b50600460008881526020019081526020016000206000808201600090556001820160006101000a81549073ffffffffffffffffffffffffffffffffffffffff0219169055600282016000610d2e91906126ca565b60038201600090556004820160009055600582016000905560068201600090555050600560008673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060009055610e71565b610dc186600460008a81526020019081526020016000206005015461254f90919063ffffffff16565b6004600089815260200190815260200160002060050181905550610e2d86600560008873ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000205461254f90919063ffffffff16565b600560008773ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020819055505b3373ffffffffffffffffffffffffffffffffffffffff168573ffffffffffffffffffffffffffffffffffffffff167fbcdc90478fd52c371057a4167fc1e7b3a5ee392c87f0c5b52be39545fdf5176689878a426040518085815260200184815260200183815260200182815260200194505050505060405180910390a350505050505050565b600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b60046020528060005260406000206000915090508060000154908060010160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1690806002018054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610ff55780601f10610fca57610100808354040283529160200191610ff5565b820191906000526020600020905b815481529060010190602001808311610fd857829003601f168201915b5050505050908060030154908060040154908060050154908060060154905087565b600080600080600860008673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002090508060000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1693508060010154925080600201549150509193909250565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161415156110f657600080fd5b600060149054906101000a900460ff16151561111157600080fd5b60008060146101000a81548160ff0219169083151502179055507f7805862f689e2f13df9f062ff482ad3ad112aca9e0847911ed832e158c525b3360405160405180910390a1565b60606000606060008061116b866125b9565b93508360405190808252806020026020018201604052801561119c5781602001602082028038833980820191505090505b50925060009050600091505b600380549050821015611292578573ffffffffffffffffffffffffffffffffffffffff16600460006003858154811015156111df57fe5b9060005260206000200154815260200190815260200160002060010160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1614156112855760038281548110151561124757fe5b9060005260206000200154838281518110151561126057fe5b906020019060200201818152505061128260018261268090919063ffffffff16565b90505b81806001019250506111a8565b82945050505050919050565b600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b600060149054906101000a900460ff1681565b600060149054906101000a900460ff161515156112f357600080fd5b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614151561134e57600080fd5b6000600860008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206001015411151561139f57600080fd5b600860008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600080820160006101000a81549073ffffffffffffffffffffffffffffffffffffffff02191690556001820160009055600282016000905550508273ffffffffffffffffffffffffffffffffffffffff167ff06d939e59bb907876936994dc10f43dfd19f20eeee14f45b43d9c544666ef3182844260405180848152602001838152602001828152602001935050505060405180910390a2505050565b6000806060600080600080600460008981526020019081526020016000209050806000015496508060010160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff169550806002018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156115615780601f1061153657610100808354040283529160200191611561565b820191906000526020600020905b81548152906001019060200180831161154457829003601f168201915b505050505094508060030154935080600401549250806005015491505091939550919395565b60065481565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161415156115e857600080fd5b600060149054906101000a900460ff1615151561160457600080fd5b6001600060146101000a81548160ff0219169083151502179055507f6985a02210a168e66602d3235cb6db0e70f92b3ba4d376a33c0f3d9434bff62560405160405180910390a1565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b600060149054906101000a900460ff1615151561168e57600080fd5b6001811015151561169e57600080fd5b60018060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166370a08231336040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001915050602060405180830381600087803b15801561175c57600080fd5b505af1158015611770573d6000803e3d6000fd5b505050506040513d602081101561178657600080fd5b8101908080519060200190929190505050101580156118ed57506117f281600560003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000205461268090919063ffffffff16565b600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166370a08231336040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001915050602060405180830381600087803b1580156118af57600080fd5b505af11580156118c3573d6000803e3d6000fd5b505050506040513d60208110156118d957600080fd5b810190808051906020019092919050505010155b15156118f857600080fd5b600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166323b872dd336000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1661196e6007548661250190919063ffffffff16565b6040518463ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018281526020019350505050602060405180830381600087803b158015611a2657600080fd5b505af1158015611a3a573d6000803e3d6000fd5b505050506040513d6020811015611a5057600080fd5b81019080805190602001909291905050501515611a6c57600080fd5b6060604051908101604052803373ffffffffffffffffffffffffffffffffffffffff16815260200182815260200142815250600860003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008201518160000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555060208201518160010155604082015181600201559050503373ffffffffffffffffffffffffffffffffffffffff167f7aab8c0bd3d4afd47e471ac30c0c2df7e1cefe87cd3d42a5715341597b094d1c8242604051808381526020018281526020019250505060405180910390a250565b60075481565b600381815481101515611ba957fe5b906000526020600020016000915090505481565b60008060149054906101000a900460ff16151515611bda57600080fd5b600073ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614151515611c1657600080fd5b60018310151515611c2657600080fd5b600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166370a08231336040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001915050602060405180830381600087803b158015611ce357600080fd5b505af1158015611cf7573d6000803e3d6000fd5b505050506040513d6020811015611d0d57600080fd5b8101908080519060200190929190505050611d70600560003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020548561268090919063ffffffff16565b11151515611d7d57600080fd5b611d93600160065461268090919063ffffffff16565b600681905550600654905060e0604051908101604052808281526020013373ffffffffffffffffffffffffffffffffffffffff16815260200183815260200186815260200185815260200184815260200142815250600460008381526020019081526020016000206000820151816000015560208201518160010160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506040820151816002019080519060200190611e68929190612712565b50606082015181600301556080820151816004015560a0820151816005015560c082015181600601559050506003819080600181540180825580915050906001820390600052602060002001600090919290919091505550611f1283600560003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000205461268090919063ffffffff16565b600560003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020819055503373ffffffffffffffffffffffffffffffffffffffff167e09646912aaa7019ad837e57cc5c0613299c8432f5268d4450ab8673fe0fa038287878742604051808681526020018581526020018481526020018381526020018281526020019550505050505060405180910390a25050505050565b60056020528060005260406000206000915090505481565b6060600380548060200260200160405190810160405280929190818152602001828054801561202f57602002820191906000526020600020905b81548152602001906001019080831161201b575b5050505050905090565b60008060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614151561209657600080fd5b3073ffffffffffffffffffffffffffffffffffffffff1631905081811115612121576000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166108fc839081150290604051600060405180830381858888f1935050505015801561211f573d6000803e3d6000fd5b505b5050565b60008060149054906101000a900460ff1615151561214257600080fd5b3373ffffffffffffffffffffffffffffffffffffffff166004600084815260200190815260200160002060010160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1614806121fe57506000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16145b151561220957600080fd5b6122716004600084815260200190815260200160002060050154600560003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000205461254f90919063ffffffff16565b600560003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020819055506122bd82612568565b905060036001600380549050038154811015156122d657fe5b90600052602060002001546003828154811015156122f057fe5b90600052602060002001819055506003805480919060019003612313919061269e565b50600460008381526020019081526020016000206000808201600090556001820160006101000a81549073ffffffffffffffffffffffffffffffffffffffff021916905560028201600061236791906126ca565b600382016000905560048201600090556005820160009055600682016000905550503373ffffffffffffffffffffffffffffffffffffffff167f6a3d5a07d548e27ae884a742682e9b929c0a0e4040990bc28c04637c5c0771048342604051808381526020018281526020019250505060405180910390a25050565b6000600560008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020549050919050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614151561248757600080fd5b600073ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff161415156124fe57806000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055505b50565b60008082840290506000841480612522575082848281151561251f57fe5b04145b151561252a57fe5b8091505092915050565b600080828481151561254257fe5b0490508091505092915050565b600082821115151561255d57fe5b818303905092915050565b600080600090505b6003805490508110156125b0578260038281548110151561258d57fe5b906000526020600020015414156125a3576125b0565b8080600101915050612570565b80915050919050565b60008060008091505b600380549050821015612676578373ffffffffffffffffffffffffffffffffffffffff16600460006003858154811015156125f957fe5b9060005260206000200154815260200190815260200160002060010160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1614156126695761266660018261268090919063ffffffff16565b90505b81806001019250506125c2565b8092505050919050565b600080828401905083811015151561269457fe5b8091505092915050565b8154818355818111156126c5578183600052602060002091820191016126c49190612792565b5b505050565b50805460018160011615610100020316600290046000825580601f106126f0575061270f565b601f01602090049060005260206000209081019061270e9190612792565b5b50565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061275357805160ff1916838001178555612781565b82800160010185558215612781579182015b82811115612780578251825591602001919060010190612765565b5b50905061278e9190612792565b5090565b6127b491905b808211156127b0576000816000905550600101612798565b5090565b905600a165627a7a72305820fc66a8b79b8c6a74fae6b810d39ce4d5e70fa1a80f0d12a1d32de15819b01f3d0029";

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

    public static final String FUNC_GETWARBYOWNER = "getWarByOwner";

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

    public static final Event WARCREATED_EVENT = new Event("WarCreated", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}),
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event AUCTIONCANCELLED_EVENT = new Event("AuctionCancelled", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}),
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event UNPAUSE_EVENT = new Event("Unpause", 
            Arrays.<TypeReference<?>>asList(),
            Arrays.<TypeReference<?>>asList());
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

    public RemoteCall<TransactionReceipt> executeEggAuction(BigInteger _auctionId, BigInteger _count, BigInteger weiValue) {
        final Function function = new Function(
                FUNC_EXECUTEEGGAUCTION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_auctionId), 
                new org.web3j.abi.datatypes.generated.Uint256(_count)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
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

    public RemoteCall<TransactionReceipt> unpause() {
        final Function function = new Function(
                FUNC_UNPAUSE, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
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

    public RemoteCall<TransactionReceipt> withdrawBalance(BigInteger amount) {
        final Function function = new Function(
                FUNC_WITHDRAWBALANCE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(amount)), 
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

    public RemoteCall<Tuple3<String, BigInteger, BigInteger>> getWarByOwner(String _owner) {
        final Function function = new Function(FUNC_GETWARBYOWNER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_owner)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        return new RemoteCall<Tuple3<String, BigInteger, BigInteger>>(
                new Callable<Tuple3<String, BigInteger, BigInteger>>() {
                    @Override
                    public Tuple3<String, BigInteger, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple3<String, BigInteger, BigInteger>(
                                (String) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue());
                    }
                });
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

    public static class WarCreatedEventResponse {
        public Log log;

        public String ower;

        public BigInteger count;

        public BigInteger time;
    }

    public static class AuctionCancelledEventResponse {
        public Log log;

        public String seller;

        public BigInteger id;

        public BigInteger time;
    }

    public static class UnpauseEventResponse {
        public Log log;
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
}
