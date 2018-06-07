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
    private static final String BINARY ="0x608060405260008060146101000a81548160ff021916908315150217905550670de0b6b3a764000060075534801561003657600080fd5b506040516040806128fc8339810180604052810190808051906020019092919080519060200190929190505050336000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555081600160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555080600260006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050506127c6806101366000396000f300608060405260043610610133576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff1680631646f3bf146101385780632be79833146101625780633070ddad146101b957806331b910b0146102b55780633f4ba83a1461030c5780634117785514610323578063451c3d80146103bb5780635c975abb146104125780636016a9f41461044157806378bd7935146104985780637aacf03c1461058d5780638456cb59146105b85780638da5cb5b146105cf578063a0a9e9e114610626578063ae4f119814610653578063b8fc28811461067e578063c0e31341146106bf578063ccfdec8c14610739578063d7c0691914610790578063da76d5cd146107fc578063e05fe5c414610829578063edd963ac14610856578063f2fde38b146108ad575b600080fd5b61016060048036038101908080359060200190929190803590602001909291905050506108f0565b005b34801561016e57600080fd5b50610177610ebd565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b3480156101c557600080fd5b506101e460048036038101908080359060200190929190505050610ee3565b604051808881526020018773ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200180602001868152602001858152602001848152602001838152602001828103825287818151815260200191508051906020019080838360005b83811015610274578082015181840152602081019050610259565b50505050905090810190601f1680156102a15780820380516001836020036101000a031916815260200191505b509850505050505050505060405180910390f35b3480156102c157600080fd5b506102f6600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610fdd565b6040518082815260200191505060405180910390f35b34801561031857600080fd5b50610321611029565b005b34801561032f57600080fd5b50610364600480360381019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291905050506110e7565b6040518080602001828103825283818151815260200191508051906020019060200280838360005b838110156103a757808201518184015260208101905061038c565b505050509050019250505060405180910390f35b3480156103c757600080fd5b506103d061122c565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b34801561041e57600080fd5b50610427611252565b604051808215151515815260200191505060405180910390f35b34801561044d57600080fd5b50610496600480360381019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291908035906020019092919080359060200190929190505050611265565b005b3480156104a457600080fd5b506104c360048036038101908080359060200190929190505050611409565b604051808781526020018673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200180602001858152602001848152602001838152602001828103825286818151815260200191508051906020019080838360005b8381101561054d578082015181840152602081019050610532565b50505050905090810190601f16801561057a5780820380516001836020036101000a031916815260200191505b5097505050505050505060405180910390f35b34801561059957600080fd5b506105a2611515565b6040518082815260200191505060405180910390f35b3480156105c457600080fd5b506105cd61151b565b005b3480156105db57600080fd5b506105e46115db565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b34801561063257600080fd5b5061065160048036038101908080359060200190929190505050611600565b005b34801561065f57600080fd5b50610668611b77565b6040518082815260200191505060405180910390f35b34801561068a57600080fd5b506106a960048036038101908080359060200190929190505050611b7d565b6040518082815260200191505060405180910390f35b610737600480360381019080803590602001909291908035906020019092919080359060200190929190803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290505050611ba0565b005b34801561074557600080fd5b5061077a600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050611fac565b6040518082815260200191505060405180910390f35b34801561079c57600080fd5b506107a5611fc4565b6040518080602001828103825283818151815260200191508051906020019060200280838360005b838110156107e85780820151818401526020810190506107cd565b505050509050019250505060405180910390f35b34801561080857600080fd5b506108276004803603810190808035906020019092919050505061201c565b005b34801561083557600080fd5b5061085460048036038101908080359060200190929190505050612108565b005b34801561086257600080fd5b50610897600480360381019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291905050506123c6565b6040518082815260200191505060405180910390f35b3480156108b957600080fd5b506108ee600480360381019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919050505061240f565b005b60008060008060008060149054906101000a900460ff1615151561091357600080fd5b6004600088815260200190815260200160002060010160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1694503373ffffffffffffffffffffffffffffffffffffffff168573ffffffffffffffffffffffffffffffffffffffff161415151561098757600080fd5b600060046000898152602001908152602001600020600501541180156109c3575085600460008981526020019081526020016000206005015410155b15156109ce57600080fd5b346109f887600460008b8152602001908152602001600020600301546124e490919063ffffffff16565b141515610a0457600080fd5b3493506000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168573ffffffffffffffffffffffffffffffffffffffff16141515610ad057610a7160648561251790919063ffffffff16565b9250610a86838561253290919063ffffffff16565b91508473ffffffffffffffffffffffffffffffffffffffff166108fc839081150290604051600060405180830381858888f19350505050158015610ace573d6000803e3d6000fd5b505b600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166323b872dd8633610b256007548b6124e490919063ffffffff16565b6040518463ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018281526020019350505050602060405180830381600087803b158015610bdd57600080fd5b505af1158015610bf1573d6000803e3d6000fd5b505050506040513d6020811015610c0757600080fd5b81019080805190602001909291905050501515610c2357600080fd5b8560046000898152602001908152602001600020600501541415610d5e57610c4a8761254b565b90506003600160038054905003815481101515610c6357fe5b9060005260206000200154600382815481101515610c7d57fe5b90600052602060002001819055506003805480919060019003610ca09190612681565b50600460008881526020019081526020016000206000808201600090556001820160006101000a81549073ffffffffffffffffffffffffffffffffffffffff0219169055600282016000610cf491906126ad565b60038201600090556004820160009055600582016000905560068201600090555050600560008673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060009055610e37565b610d8786600460008a81526020019081526020016000206005015461253290919063ffffffff16565b6004600089815260200190815260200160002060050181905550610df386600560008873ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000205461253290919063ffffffff16565b600560008773ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020819055505b3373ffffffffffffffffffffffffffffffffffffffff168573ffffffffffffffffffffffffffffffffffffffff167fbcdc90478fd52c371057a4167fc1e7b3a5ee392c87f0c5b52be39545fdf5176689878a426040518085815260200184815260200183815260200182815260200194505050505060405180910390a350505050505050565b600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b60046020528060005260406000206000915090508060000154908060010160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1690806002018054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610fbb5780601f10610f9057610100808354040283529160200191610fbb565b820191906000526020600020905b815481529060010190602001808311610f9e57829003601f168201915b5050505050908060030154908060040154908060050154908060060154905087565b6000600860008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600101549050919050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614151561108457600080fd5b600060149054906101000a900460ff16151561109f57600080fd5b60008060146101000a81548160ff0219169083151502179055507f7805862f689e2f13df9f062ff482ad3ad112aca9e0847911ed832e158c525b3360405160405180910390a1565b6060600060606000806110f98661259c565b93508360405190808252806020026020018201604052801561112a5781602001602082028038833980820191505090505b50925060009050600091505b600380549050821015611220578573ffffffffffffffffffffffffffffffffffffffff166004600060038581548110151561116d57fe5b9060005260206000200154815260200190815260200160002060010160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff161415611213576003828154811015156111d557fe5b906000526020600020015483828151811015156111ee57fe5b906020019060200201818152505061121060018261266390919063ffffffff16565b90505b8180600101925050611136565b82945050505050919050565b600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b600060149054906101000a900460ff1681565b600060149054906101000a900460ff1615151561128157600080fd5b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161415156112dc57600080fd5b6000600860008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206001015411151561132d57600080fd5b600860008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600080820160006101000a81549073ffffffffffffffffffffffffffffffffffffffff02191690556001820160009055600282016000905550508273ffffffffffffffffffffffffffffffffffffffff167ff06d939e59bb907876936994dc10f43dfd19f20eeee14f45b43d9c544666ef3182844260405180848152602001838152602001828152602001935050505060405180910390a2505050565b6000806060600080600080600460008981526020019081526020016000209050806000015496508060010160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff169550806002018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156114ef5780601f106114c4576101008083540402835291602001916114ef565b820191906000526020600020905b8154815290600101906020018083116114d257829003601f168201915b505050505094508060030154935080600401549250806005015491505091939550919395565b60065481565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614151561157657600080fd5b600060149054906101000a900460ff1615151561159257600080fd5b6001600060146101000a81548160ff0219169083151502179055507f6985a02210a168e66602d3235cb6db0e70f92b3ba4d376a33c0f3d9434bff62560405160405180910390a1565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b600060149054906101000a900460ff1615151561161c57600080fd5b600a90506001811015151561163057600080fd5b6000600860003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206001015414151561168157600080fd5b60018060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166370a08231336040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001915050602060405180830381600087803b15801561173f57600080fd5b505af1158015611753573d6000803e3d6000fd5b505050506040513d602081101561176957600080fd5b8101908080519060200190929190505050101580156118d057506117d581600560003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000205461266390919063ffffffff16565b600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166370a08231336040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001915050602060405180830381600087803b15801561189257600080fd5b505af11580156118a6573d6000803e3d6000fd5b505050506040513d60208110156118bc57600080fd5b810190808051906020019092919050505010155b15156118db57600080fd5b600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166323b872dd336000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff16611951600754866124e490919063ffffffff16565b6040518463ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018281526020019350505050602060405180830381600087803b158015611a0957600080fd5b505af1158015611a1d573d6000803e3d6000fd5b505050506040513d6020811015611a3357600080fd5b81019080805190602001909291905050501515611a4f57600080fd5b6060604051908101604052803373ffffffffffffffffffffffffffffffffffffffff16815260200182815260200142815250600860003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008201518160000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555060208201518160010155604082015181600201559050503373ffffffffffffffffffffffffffffffffffffffff167f7aab8c0bd3d4afd47e471ac30c0c2df7e1cefe87cd3d42a5715341597b094d1c8242604051808381526020018281526020019250505060405180910390a250565b60075481565b600381815481101515611b8c57fe5b906000526020600020016000915090505481565b60008060149054906101000a900460ff16151515611bbd57600080fd5b600073ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614151515611bf957600080fd5b60018310151515611c0957600080fd5b600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166370a08231336040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001915050602060405180830381600087803b158015611cc657600080fd5b505af1158015611cda573d6000803e3d6000fd5b505050506040513d6020811015611cf057600080fd5b8101908080519060200190929190505050611d53600560003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020548561266390919063ffffffff16565b11151515611d6057600080fd5b611d76600160065461266390919063ffffffff16565b600681905550600654905060e0604051908101604052808281526020013373ffffffffffffffffffffffffffffffffffffffff16815260200183815260200186815260200185815260200184815260200142815250600460008381526020019081526020016000206000820151816000015560208201518160010160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506040820151816002019080519060200190611e4b9291906126f5565b50606082015181600301556080820151816004015560a0820151816005015560c082015181600601559050506003819080600181540180825580915050906001820390600052602060002001600090919290919091505550611ef583600560003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000205461266390919063ffffffff16565b600560003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020819055503373ffffffffffffffffffffffffffffffffffffffff167e09646912aaa7019ad837e57cc5c0613299c8432f5268d4450ab8673fe0fa038287878742604051808681526020018581526020018481526020018381526020018281526020019550505050505060405180910390a25050505050565b60056020528060005260406000206000915090505481565b6060600380548060200260200160405190810160405280929190818152602001828054801561201257602002820191906000526020600020905b815481526020019060010190808311611ffe575b5050505050905090565b60008060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614151561207957600080fd5b3073ffffffffffffffffffffffffffffffffffffffff1631905081811115612104576000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166108fc839081150290604051600060405180830381858888f19350505050158015612102573d6000803e3d6000fd5b505b5050565b60008060149054906101000a900460ff1615151561212557600080fd5b3373ffffffffffffffffffffffffffffffffffffffff166004600084815260200190815260200160002060010160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1614806121e157506000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16145b15156121ec57600080fd5b6122546004600084815260200190815260200160002060050154600560003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000205461253290919063ffffffff16565b600560003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020819055506122a08261254b565b905060036001600380549050038154811015156122b957fe5b90600052602060002001546003828154811015156122d357fe5b906000526020600020018190555060038054809190600190036122f69190612681565b50600460008381526020019081526020016000206000808201600090556001820160006101000a81549073ffffffffffffffffffffffffffffffffffffffff021916905560028201600061234a91906126ad565b600382016000905560048201600090556005820160009055600682016000905550503373ffffffffffffffffffffffffffffffffffffffff167f6a3d5a07d548e27ae884a742682e9b929c0a0e4040990bc28c04637c5c0771048342604051808381526020018281526020019250505060405180910390a25050565b6000600560008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020549050919050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614151561246a57600080fd5b600073ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff161415156124e157806000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055505b50565b60008082840290506000841480612505575082848281151561250257fe5b04145b151561250d57fe5b8091505092915050565b600080828481151561252557fe5b0490508091505092915050565b600082821115151561254057fe5b818303905092915050565b600080600090505b600380549050811015612593578260038281548110151561257057fe5b9060005260206000200154141561258657612593565b8080600101915050612553565b80915050919050565b60008060008091505b600380549050821015612659578373ffffffffffffffffffffffffffffffffffffffff16600460006003858154811015156125dc57fe5b9060005260206000200154815260200190815260200160002060010160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16141561264c5761264960018261266390919063ffffffff16565b90505b81806001019250506125a5565b8092505050919050565b600080828401905083811015151561267757fe5b8091505092915050565b8154818355818111156126a8578183600052602060002091820191016126a79190612775565b5b505050565b50805460018160011615610100020316600290046000825580601f106126d357506126f2565b601f0160209004906000526020600020908101906126f19190612775565b5b50565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061273657805160ff1916838001178555612764565b82800160010185558215612764579182015b82811115612763578251825591602001919060010190612748565b5b5090506127719190612775565b5090565b61279791905b8082111561279357600081600090555060010161277b565b5090565b905600a165627a7a723058205dcd11f261fcabda22d21a02e190da3655f3610945531941c9e5dab7e5be35010029";
    		
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
