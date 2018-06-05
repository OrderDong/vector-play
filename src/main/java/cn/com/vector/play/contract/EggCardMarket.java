package cn.com.vector.play.contract;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
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
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple2;
import org.web3j.tuples.generated.Tuple5;
import org.web3j.tuples.generated.Tuple6;
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
public class EggCardMarket extends Contract {
    private static final String BINARY = "0x608060405260008060146101000a81548160ff02191690831515021790555034801561002a57600080fd5b50604051604080611e318339810180604052810190808051906020019092919080519060200190929190505050336000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555081600160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555080600260006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055505050611d078061012a6000396000f300608060405260043610610107576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff16806305597d881461010c578063064f56921461013c57806317e8ec361461016957806318c909e5146101f9578063327d364f146102505780633e16a270146102a75780633f4ba83a146102d2578063451c3d80146102e95780635c975abb146103405780638456cb591461036f5780638da5cb5b14610386578063af8996f1146103dd578063b8fd52351461040a578063cafc7c2c14610493578063cc720b66146104be578063eaed2110146104de578063f2fde38b14610551578063f303a52014610594578063feb2c4df1461062c575b600080fd5b34801561011857600080fd5b5061013a600480360381019080803560ff16906020019092919050505061066d565b005b34801561014857600080fd5b5061016760048036038101908080359060200190929190505050610720565b005b34801561017557600080fd5b5061019460048036038101908080359060200190929190505050610a56565b604051808781526020018673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001858152602001848152602001838152602001828152602001965050505050505060405180910390f35b34801561020557600080fd5b5061020e610ab2565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b34801561025c57600080fd5b50610291600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610ad8565b6040518082815260200191505060405180910390f35b3480156102b357600080fd5b506102bc610b21565b6040518082815260200191505060405180910390f35b3480156102de57600080fd5b506102e7610b27565b005b3480156102f557600080fd5b506102fe610be5565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b34801561034c57600080fd5b50610355610c0b565b604051808215151515815260200191505060405180910390f35b34801561037b57600080fd5b50610384610c1e565b005b34801561039257600080fd5b5061039b610cde565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b3480156103e957600080fd5b5061040860048036038101908080359060200190929190505050610d03565b005b34801561041657600080fd5b5061043560048036038101908080359060200190929190505050610da1565b604051808681526020018573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018481526020018381526020018281526020019550505050505060405180910390f35b34801561049f57600080fd5b506104a8610e87565b6040518082815260200191505060405180910390f35b6104dc60048036038101908080359060200190929190505050610e8d565b005b3480156104ea57600080fd5b506104f36114df565b6040518083815260200180602001828103825283818151815260200191508051906020019060200280838360005b8381101561053c578082015181840152602081019050610521565b50505050905001935050505060405180910390f35b34801561055d57600080fd5b50610592600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050611545565b005b3480156105a057600080fd5b506105d5600480360381019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919050505061169a565b6040518080602001828103825283818151815260200191508051906020019060200280838360005b838110156106185780820151818401526020810190506105fd565b505050509050019250505060405180910390f35b34801561063857600080fd5b5061066b600480360381019080803590602001909291908035906020019092919080359060200190929190505050611813565b005b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161415156106c857600080fd5b60648160ff161015156106da57600080fd5b8060ff166006819055507f318a03d593a9ae84a371201241efc481240c14fca9adad13b0dd88e388e046296006546040518082815260200191505060405180910390a150565b60008060008060149054906101000a900460ff1615151561074057600080fd5b3373ffffffffffffffffffffffffffffffffffffffff166004600086815260200190815260200160002060010160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1614806107fc57506000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16145b151561080757600080fd5b600460008581526020019081526020016000206000015492506004600085815260200190815260200160002060010160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff169150600460008581526020019081526020016000206000808201600090556001820160006101000a81549073ffffffffffffffffffffffffffffffffffffffff0219169055600282016000905560038201600090556004820160009055600582016000905550506109116001600560003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002054611bb590919063ffffffff16565b600560003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000208190555061095d84611bce565b9050600361097a6001600380549050611bb590919063ffffffff16565b81548110151561098657fe5b90600052602060002001546003828154811015156109a057fe5b906000526020600020018190555060036109c96001600380549050611bb590919063ffffffff16565b8154811015156109d557fe5b906000526020600020016000905560038054809190600190036109f89190611c3d565b508173ffffffffffffffffffffffffffffffffffffffff16847f7b93af227da00ee9987a29d2984e6d1cf8df9cff9d1b899bee5cd6d203fae8188542604051808381526020018281526020019250505060405180910390a350505050565b60046020528060005260406000206000915090508060000154908060010160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16908060020154908060030154908060040154908060050154905086565b600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b6000600560008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020549050919050565b60075481565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515610b8257600080fd5b600060149054906101000a900460ff161515610b9d57600080fd5b60008060146101000a81548160ff0219169083151502179055507f7805862f689e2f13df9f062ff482ad3ad112aca9e0847911ed832e158c525b3360405160405180910390a1565b600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b600060149054906101000a900460ff1681565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515610c7957600080fd5b600060149054906101000a900460ff16151515610c9557600080fd5b6001600060146101000a81548160ff0219169083151502179055507f6985a02210a168e66602d3235cb6db0e70f92b3ba4d376a33c0f3d9434bff62560405160405180910390a1565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515610d5e57600080fd5b806007819055507f779715e3a52a2acfdefc752682585c78a51b6d14241783d6a8c8b296862c6fc56007546040518082815260200191505060405180910390a150565b6000806000806000610db1611c69565b6004600088815260200190815260200160002060c06040519081016040529081600082015481526020016001820160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001600282015481526020016003820154815260200160048201548152602001600582015481525050905080600001519550806020015194508060400151935080606001519250806080015191505091939590929450565b60065481565b60008060008060008060149054906101000a900460ff16151515610eb057600080fd5b6004600087815260200190815260200160002060010160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff169450600460008781526020019081526020016000206002015493503373ffffffffffffffffffffffffffffffffffffffff168573ffffffffffffffffffffffffffffffffffffffff1614151515610f3d57600080fd5b600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16636352211e876040518263ffffffff167c010000000000000000000000000000000000000000000000000000000002815260040180828152602001915050602060405180830381600087803b158015610fce57600080fd5b505af1158015610fe2573d6000803e3d6000fd5b505050506040513d6020811015610ff857600080fd5b810190808051906020019092919050505073ffffffffffffffffffffffffffffffffffffffff168573ffffffffffffffffffffffffffffffffffffffff1614151561104257600080fd5b60009250600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166323b872dd33876110998789611bb590919063ffffffff16565b6040518463ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018281526020019350505050602060405180830381600087803b15801561115157600080fd5b505af1158015611165573d6000803e3d6000fd5b505050506040513d602081101561117b57600080fd5b8101908080519060200190929190505050151561119757600080fd5b600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166342842e0e8633896040518463ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018281526020019350505050600060405180830381600087803b15801561129057600080fd5b505af11580156112a4573d6000803e3d6000fd5b5050505060046000878152602001908152602001600020600001549150600460008781526020019081526020016000206000808201600090556001820160006101000a81549073ffffffffffffffffffffffffffffffffffffffff0219169055600282016000905560038201600090556004820160009055600582016000905550506113796001600560008873ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002054611bb590919063ffffffff16565b600560008773ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020819055506113c586611bce565b905060036113e26001600380549050611bb590919063ffffffff16565b8154811015156113ee57fe5b906000526020600020015460038281548110151561140857fe5b906000526020600020018190555060036114316001600380549050611bb590919063ffffffff16565b81548110151561143d57fe5b906000526020600020016000905560038054809190600190036114609190611c3d565b503373ffffffffffffffffffffffffffffffffffffffff168573ffffffffffffffffffffffffffffffffffffffff16877f7c7ff61a48327aea3aec44f55cf2eee3ecfaca89b0c8f2780a76b86d03ca06a585884260405180848152602001838152602001828152602001935050505060405180910390a4505050505050565b6000606060038054905060038080548060200260200160405190810160405280929190818152602001828054801561153657602002820191906000526020600020905b815481526020019060010190808311611522575b50505050509050915091509091565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161415156115a057600080fd5b600073ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff16141515156115dc57600080fd5b8073ffffffffffffffffffffffffffffffffffffffff166000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff167f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e060405160405180910390a3806000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050565b6060600060606000806116ac86610ad8565b935060008414156116ef5760006040519080825280602002602001820160405280156116e75781602001602082028038833980820191505090505b50945061180a565b8360405190808252806020026020018201604052801561171e5781602001602082028038833980820191505090505b50925060009050600091505b600380549050821015611806578573ffffffffffffffffffffffffffffffffffffffff166004600060038581548110151561176157fe5b9060005260206000200154815260200190815260200160002060010160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1614156117f9576003828154811015156117c957fe5b906000526020600020015483828151811015156117e257fe5b906020019060200201818152505080806001019150505b818060010192505061172a565b8294505b50505050919050565b60008060149054906101000a900460ff1615151561183057600080fd5b600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16636352211e856040518263ffffffff167c010000000000000000000000000000000000000000000000000000000002815260040180828152602001915050602060405180830381600087803b1580156118c157600080fd5b505af11580156118d5573d6000803e3d6000fd5b505050506040513d60208110156118eb57600080fd5b810190808051906020019092919050505073ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614151561193557600080fd5b60008311151561194457600080fd5b42338585604051808581526020018473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166c01000000000000000000000000028152601401838152602001828152602001945050505050604051809103902060019004905060c0604051908101604052808281526020013373ffffffffffffffffffffffffffffffffffffffff16815260200184815260200183815260200142815260200185815250600460008681526020019081526020016000206000820151816000015560208201518160010160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555060408201518160020155606082015181600301556080820151816004015560a08201518160050155905050611ad96001600560003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002054611c1f90919063ffffffff16565b600560003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000208190555060038490806001815401808255809150509060018203906000526020600020016000909192909190915055503373ffffffffffffffffffffffffffffffffffffffff16847fc661bf33c6dc5be02728e075e8b4084fc0be6f94010c60f2980720e5c50edb31838686426040518085815260200184815260200183815260200182815260200194505050505060405180910390a350505050565b6000828211151515611bc357fe5b818303905092915050565b600080600090505b600380549050811015611c165782600382815481101515611bf357fe5b90600052602060002001541415611c0957611c16565b8080600101915050611bd6565b80915050919050565b6000808284019050838110151515611c3357fe5b8091505092915050565b815481835581811115611c6457818360005260206000209182019101611c639190611cb6565b5b505050565b60c06040519081016040528060008152602001600073ffffffffffffffffffffffffffffffffffffffff168152602001600081526020016000815260200160008152602001600081525090565b611cd891905b80821115611cd4576000816000905550600101611cbc565b5090565b905600a165627a7a72305820e9399c26ff831092da337cd2b0a16fb01d2baeaeaa60912caccf3ba08138dd870029";

    public static final String FUNC_AUCTIONBYTOKENID = "auctionByTokenId";

    public static final String FUNC_NONREGISTRY = "nonRegistry";

    public static final String FUNC_FEEINWEI = "feeInWei";

    public static final String FUNC_UNPAUSE = "unpause";

    public static final String FUNC_ACCEPTEDTOKEN = "acceptedToken";

    public static final String FUNC_PAUSED = "paused";

    public static final String FUNC_PAUSE = "pause";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_OWNERCUTFEE = "ownerCutFee";

    public static final String FUNC_TRANSFEROWNERSHIP = "transferOwnership";

    public static final String FUNC_SETPUBLICATIONFEE = "setPublicationFee";

    public static final String FUNC_SETOWNERCUT = "setOwnerCut";

    public static final String FUNC_CREATECARDAUCTION = "createCardAuction";

    public static final String FUNC_CANCELCARDAUCTION = "cancelCardAuction";

    public static final String FUNC_EXECUTECARDAUCTION = "executeCardAuction";

    public static final String FUNC_COUNTAUCTIONOF = "countAuctionOf";

    public static final String FUNC_AUCTIONOFOWNER = "auctionOfOwner";

    public static final String FUNC_GETCARDAUCTION = "getCardAuction";

    public static final String FUNC_GETAUCTIONINDEX = "getAuctionIndex";

    public static final Event CARDAUCTIONCREATED_EVENT = new Event("CardAuctionCreated", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Address>() {}),
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event CARDAUCTIONSUCCESSFUL_EVENT = new Event("CardAuctionSuccessful", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Address>() {}, new TypeReference<Address>() {}),
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event CARDAUCTIONCANCELLED_EVENT = new Event("CardAuctionCancelled", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Address>() {}),
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event CHANGEDFEE_EVENT = new Event("ChangedFee", 
            Arrays.<TypeReference<?>>asList(),
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
    ;

    public static final Event CHANGEDOWNERCUT_EVENT = new Event("ChangedOwnerCut", 
            Arrays.<TypeReference<?>>asList(),
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
    ;

    public static final Event PAUSE_EVENT = new Event("Pause", 
            Arrays.<TypeReference<?>>asList(),
            Arrays.<TypeReference<?>>asList());
    ;

    public static final Event UNPAUSE_EVENT = new Event("Unpause", 
            Arrays.<TypeReference<?>>asList(),
            Arrays.<TypeReference<?>>asList());
    ;

    public static final Event OWNERSHIPTRANSFERRED_EVENT = new Event("OwnershipTransferred", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}),
            Arrays.<TypeReference<?>>asList());
    ;

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
    }

    protected EggCardMarket(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected EggCardMarket(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public RemoteCall<Tuple6<BigInteger, String, BigInteger, BigInteger, BigInteger, BigInteger>> auctionByTokenId(BigInteger param0) {
        final Function function = new Function(FUNC_AUCTIONBYTOKENID, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        return new RemoteCall<Tuple6<BigInteger, String, BigInteger, BigInteger, BigInteger, BigInteger>>(
                new Callable<Tuple6<BigInteger, String, BigInteger, BigInteger, BigInteger, BigInteger>>() {
                    @Override
                    public Tuple6<BigInteger, String, BigInteger, BigInteger, BigInteger, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple6<BigInteger, String, BigInteger, BigInteger, BigInteger, BigInteger>(
                                (BigInteger) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue(), 
                                (BigInteger) results.get(3).getValue(), 
                                (BigInteger) results.get(4).getValue(), 
                                (BigInteger) results.get(5).getValue());
                    }
                });
    }

    public RemoteCall<String> nonRegistry() {
        final Function function = new Function(FUNC_NONREGISTRY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<BigInteger> feeInWei() {
        final Function function = new Function(FUNC_FEEINWEI, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> unpause() {
        final Function function = new Function(
                FUNC_UNPAUSE, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> acceptedToken() {
        final Function function = new Function(FUNC_ACCEPTEDTOKEN, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<Boolean> paused() {
        final Function function = new Function(FUNC_PAUSED, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<TransactionReceipt> pause() {
        final Function function = new Function(
                FUNC_PAUSE, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> owner() {
        final Function function = new Function(FUNC_OWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<BigInteger> ownerCutFee() {
        final Function function = new Function(FUNC_OWNERCUTFEE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> transferOwnership(String newOwner) {
        final Function function = new Function(
                FUNC_TRANSFEROWNERSHIP, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(newOwner)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public static RemoteCall<EggCardMarket> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _acceptedToken, String _nonRegistry) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_acceptedToken), 
                new org.web3j.abi.datatypes.Address(_nonRegistry)));
        return deployRemoteCall(EggCardMarket.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static RemoteCall<EggCardMarket> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _acceptedToken, String _nonRegistry) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_acceptedToken), 
                new org.web3j.abi.datatypes.Address(_nonRegistry)));
        return deployRemoteCall(EggCardMarket.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public List<CardAuctionCreatedEventResponse> getCardAuctionCreatedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(CARDAUCTIONCREATED_EVENT, transactionReceipt);
        ArrayList<CardAuctionCreatedEventResponse> responses = new ArrayList<CardAuctionCreatedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            CardAuctionCreatedEventResponse typedResponse = new CardAuctionCreatedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.tokenId = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.seller = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.id = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.priceInWei = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.expiresAt = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.time = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<CardAuctionCreatedEventResponse> cardAuctionCreatedEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, CardAuctionCreatedEventResponse>() {
            @Override
            public CardAuctionCreatedEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(CARDAUCTIONCREATED_EVENT, log);
                CardAuctionCreatedEventResponse typedResponse = new CardAuctionCreatedEventResponse();
                typedResponse.log = log;
                typedResponse.tokenId = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.seller = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.id = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.priceInWei = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.expiresAt = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
                typedResponse.time = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<CardAuctionCreatedEventResponse> cardAuctionCreatedEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(CARDAUCTIONCREATED_EVENT));
        return cardAuctionCreatedEventObservable(filter);
    }

    public List<CardAuctionSuccessfulEventResponse> getCardAuctionSuccessfulEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(CARDAUCTIONSUCCESSFUL_EVENT, transactionReceipt);
        ArrayList<CardAuctionSuccessfulEventResponse> responses = new ArrayList<CardAuctionSuccessfulEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            CardAuctionSuccessfulEventResponse typedResponse = new CardAuctionSuccessfulEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.tokenId = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.seller = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.buyer = (String) eventValues.getIndexedValues().get(2).getValue();
            typedResponse.id = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.totalPrice = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.time = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<CardAuctionSuccessfulEventResponse> cardAuctionSuccessfulEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, CardAuctionSuccessfulEventResponse>() {
            @Override
            public CardAuctionSuccessfulEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(CARDAUCTIONSUCCESSFUL_EVENT, log);
                CardAuctionSuccessfulEventResponse typedResponse = new CardAuctionSuccessfulEventResponse();
                typedResponse.log = log;
                typedResponse.tokenId = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.seller = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.buyer = (String) eventValues.getIndexedValues().get(2).getValue();
                typedResponse.id = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.totalPrice = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.time = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<CardAuctionSuccessfulEventResponse> cardAuctionSuccessfulEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(CARDAUCTIONSUCCESSFUL_EVENT));
        return cardAuctionSuccessfulEventObservable(filter);
    }

    public List<CardAuctionCancelledEventResponse> getCardAuctionCancelledEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(CARDAUCTIONCANCELLED_EVENT, transactionReceipt);
        ArrayList<CardAuctionCancelledEventResponse> responses = new ArrayList<CardAuctionCancelledEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            CardAuctionCancelledEventResponse typedResponse = new CardAuctionCancelledEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.tokenId = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.seller = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.id = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.time = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<CardAuctionCancelledEventResponse> cardAuctionCancelledEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, CardAuctionCancelledEventResponse>() {
            @Override
            public CardAuctionCancelledEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(CARDAUCTIONCANCELLED_EVENT, log);
                CardAuctionCancelledEventResponse typedResponse = new CardAuctionCancelledEventResponse();
                typedResponse.log = log;
                typedResponse.tokenId = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.seller = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.id = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.time = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<CardAuctionCancelledEventResponse> cardAuctionCancelledEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(CARDAUCTIONCANCELLED_EVENT));
        return cardAuctionCancelledEventObservable(filter);
    }

    public List<ChangedFeeEventResponse> getChangedFeeEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(CHANGEDFEE_EVENT, transactionReceipt);
        ArrayList<ChangedFeeEventResponse> responses = new ArrayList<ChangedFeeEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ChangedFeeEventResponse typedResponse = new ChangedFeeEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.publicationFee = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<ChangedFeeEventResponse> changedFeeEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, ChangedFeeEventResponse>() {
            @Override
            public ChangedFeeEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(CHANGEDFEE_EVENT, log);
                ChangedFeeEventResponse typedResponse = new ChangedFeeEventResponse();
                typedResponse.log = log;
                typedResponse.publicationFee = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<ChangedFeeEventResponse> changedFeeEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(CHANGEDFEE_EVENT));
        return changedFeeEventObservable(filter);
    }

    public List<ChangedOwnerCutEventResponse> getChangedOwnerCutEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(CHANGEDOWNERCUT_EVENT, transactionReceipt);
        ArrayList<ChangedOwnerCutEventResponse> responses = new ArrayList<ChangedOwnerCutEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ChangedOwnerCutEventResponse typedResponse = new ChangedOwnerCutEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.ownerCut = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<ChangedOwnerCutEventResponse> changedOwnerCutEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, ChangedOwnerCutEventResponse>() {
            @Override
            public ChangedOwnerCutEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(CHANGEDOWNERCUT_EVENT, log);
                ChangedOwnerCutEventResponse typedResponse = new ChangedOwnerCutEventResponse();
                typedResponse.log = log;
                typedResponse.ownerCut = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<ChangedOwnerCutEventResponse> changedOwnerCutEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(CHANGEDOWNERCUT_EVENT));
        return changedOwnerCutEventObservable(filter);
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

    public List<OwnershipTransferredEventResponse> getOwnershipTransferredEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(OWNERSHIPTRANSFERRED_EVENT, transactionReceipt);
        ArrayList<OwnershipTransferredEventResponse> responses = new ArrayList<OwnershipTransferredEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            OwnershipTransferredEventResponse typedResponse = new OwnershipTransferredEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.previousOwner = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.newOwner = (String) eventValues.getIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<OwnershipTransferredEventResponse> ownershipTransferredEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, OwnershipTransferredEventResponse>() {
            @Override
            public OwnershipTransferredEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(OWNERSHIPTRANSFERRED_EVENT, log);
                OwnershipTransferredEventResponse typedResponse = new OwnershipTransferredEventResponse();
                typedResponse.log = log;
                typedResponse.previousOwner = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.newOwner = (String) eventValues.getIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<OwnershipTransferredEventResponse> ownershipTransferredEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(OWNERSHIPTRANSFERRED_EVENT));
        return ownershipTransferredEventObservable(filter);
    }

    public RemoteCall<TransactionReceipt> setPublicationFee(BigInteger _feeInWei) {
        final Function function = new Function(
                FUNC_SETPUBLICATIONFEE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_feeInWei)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> setOwnerCut(BigInteger _ownerCutFee) {
        final Function function = new Function(
                FUNC_SETOWNERCUT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint8(_ownerCutFee)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> createCardAuction(BigInteger tokenId, BigInteger priceInWei, BigInteger expiresAt) {
        final Function function = new Function(
                FUNC_CREATECARDAUCTION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(tokenId), 
                new org.web3j.abi.datatypes.generated.Uint256(priceInWei), 
                new org.web3j.abi.datatypes.generated.Uint256(expiresAt)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> cancelCardAuction(BigInteger tokenId) {
        final Function function = new Function(
                FUNC_CANCELCARDAUCTION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(tokenId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> executeCardAuction(BigInteger tokenId, BigInteger weiValue) {
        final Function function = new Function(
                FUNC_EXECUTECARDAUCTION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(tokenId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteCall<BigInteger> countAuctionOf(String _owner) {
        final Function function = new Function(FUNC_COUNTAUCTIONOF, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_owner)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<List> auctionOfOwner(String _owner) {
        final Function function = new Function(FUNC_AUCTIONOFOWNER, 
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

    public RemoteCall<Tuple5<BigInteger, String, BigInteger, BigInteger, BigInteger>> getCardAuction(BigInteger _tokenId) {
        final Function function = new Function(FUNC_GETCARDAUCTION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_tokenId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        return new RemoteCall<Tuple5<BigInteger, String, BigInteger, BigInteger, BigInteger>>(
                new Callable<Tuple5<BigInteger, String, BigInteger, BigInteger, BigInteger>>() {
                    @Override
                    public Tuple5<BigInteger, String, BigInteger, BigInteger, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple5<BigInteger, String, BigInteger, BigInteger, BigInteger>(
                                (BigInteger) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue(), 
                                (BigInteger) results.get(3).getValue(), 
                                (BigInteger) results.get(4).getValue());
                    }
                });
    }

    public RemoteCall<Tuple2<BigInteger, List<BigInteger>>> getAuctionIndex() {
        final Function function = new Function(FUNC_GETAUCTIONINDEX, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<DynamicArray<Uint256>>() {}));
        return new RemoteCall<Tuple2<BigInteger, List<BigInteger>>>(
                new Callable<Tuple2<BigInteger, List<BigInteger>>>() {
                    @Override
                    public Tuple2<BigInteger, List<BigInteger>> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple2<BigInteger, List<BigInteger>>(
                                (BigInteger) results.get(0).getValue(), 
                                convertToNative((List<Uint256>) results.get(1).getValue()));
                    }
                });
    }

    public static EggCardMarket load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new EggCardMarket(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static EggCardMarket load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new EggCardMarket(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static class CardAuctionCreatedEventResponse {
        public Log log;

        public BigInteger tokenId;

        public String seller;

        public BigInteger id;

        public BigInteger priceInWei;

        public BigInteger expiresAt;

        public BigInteger time;
    }

    public static class CardAuctionSuccessfulEventResponse {
        public Log log;

        public BigInteger tokenId;

        public String seller;

        public String buyer;

        public BigInteger id;

        public BigInteger totalPrice;

        public BigInteger time;
    }

    public static class CardAuctionCancelledEventResponse {
        public Log log;

        public BigInteger tokenId;

        public String seller;

        public BigInteger id;

        public BigInteger time;
    }

    public static class ChangedFeeEventResponse {
        public Log log;

        public BigInteger publicationFee;
    }

    public static class ChangedOwnerCutEventResponse {
        public Log log;

        public BigInteger ownerCut;
    }

    public static class PauseEventResponse {
        public Log log;
    }

    public static class UnpauseEventResponse {
        public Log log;
    }

    public static class OwnershipTransferredEventResponse {
        public Log log;

        public String previousOwner;

        public String newOwner;
    }
}
