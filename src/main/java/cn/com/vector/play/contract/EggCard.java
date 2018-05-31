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
import org.web3j.abi.datatypes.generated.Uint16;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple2;
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
public class EggCard extends Contract {
    private static final String BINARY = "0x60806040526000600160146101000a81548160ff021916908315150217905550600f60025534801561003057600080fd5b5060405160208061219d833981018060405281019080805190602001909291905050506000600160146101000a81548160ff021916908315150217905550336000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555080600160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055505061209e806100ff6000396000f300608060405260043610610175576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff1680630519ce791461017a57806306fdde03146101d1578063095ea7b3146102615780630a0f8168146102ae57806318160ddd1461030557806327d7874c146103305780632b72cbcf146103735780633639ff8a146103a05780633f4ba83a1461041857806342842e0e1461042f5780634d137f6a1461049c5780634e0a33791461050f57806352853b41146105525780635c975abb146105955780636352211e146105c45780636af04a571461063157806370a082311461068857806371587988146106df57806378d0df50146107225780637a7d49371461078f5780638456cb59146107ba5780638462151c146107d15780638e328700146108695780639188d312146108d657806395d89b4114610941578063a9059cbb146109d1578063c314734614610a1e578063d72b6d3b14610a49578063ddc6a17114610a74575b600080fd5b34801561018657600080fd5b5061018f610ad9565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b3480156101dd57600080fd5b506101e6610aff565b6040518080602001828103825283818151815260200191508051906020019080838360005b8381101561022657808201518184015260208101905061020b565b50505050905090810190601f1680156102535780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b34801561026d57600080fd5b506102ac600480360381019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919080359060200190929190505050610b38565b005b3480156102ba57600080fd5b506102c3610c16565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b34801561031157600080fd5b5061031a610c3b565b6040518082815260200191505060405180910390f35b34801561033c57600080fd5b50610371600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610c5b565b005b34801561037f57600080fd5b5061039e60048036038101908080359060200190929190505050610d35565b005b3480156103ac57600080fd5b506104026004803603810190808035906020019092919080359060200190929190803560ff169060200190929190803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610e08565b6040518082815260200191505060405180910390f35b34801561042457600080fd5b5061042d610eda565b005b34801561043b57600080fd5b5061049a600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803573ffffffffffffffffffffffffffffffffffffffff16906020019092919080359060200190929190505050610fb7565b005b3480156104a857600080fd5b506104b1611084565b6040518083815260200180602001828103825283818151815260200191508051906020019060200280838360005b838110156104fa5780820151818401526020810190506104df565b50505050905001935050505060405180910390f35b34801561051b57600080fd5b50610550600480360381019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919050505061112f565b005b34801561055e57600080fd5b50610593600480360381019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919050505061120a565b005b3480156105a157600080fd5b506105aa6112fb565b604051808215151515815260200191505060405180910390f35b3480156105d057600080fd5b506105ef6004803603810190808035906020019092919050505061130e565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b34801561063d57600080fd5b50610646611387565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b34801561069457600080fd5b506106c9600480360381019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291905050506113ad565b6040518082815260200191505060405180910390f35b3480156106eb57600080fd5b50610720600480360381019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291905050506113f6565b005b34801561072e57600080fd5b5061074d60048036038101908080359060200190929190505050611513565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b34801561079b57600080fd5b506107a4611546565b6040518082815260200191505060405180910390f35b3480156107c657600080fd5b506107cf61154c565b005b3480156107dd57600080fd5b50610812600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050611637565b6040518080602001828103825283818151815260200191508051906020019060200280838360005b8381101561085557808201518184015260208101905061083a565b505050509050019250505060405180910390f35b34801561087557600080fd5b5061089460048036038101908080359060200190929190505050611784565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b3480156108e257600080fd5b50610901600480360381019080803590602001909291905050506117b7565b6040518088815260200187815260200186815260200185815260200184815260200183815260200182815260200197505050505050505060405180910390f35b34801561094d57600080fd5b50610956611853565b6040518080602001828103825283818151815260200191508051906020019080838360005b8381101561099657808201518184015260208101905061097b565b50505050905090810190601f1680156109c35780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b3480156109dd57600080fd5b50610a1c600480360381019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291908035906020019092919050505061188c565b005b348015610a2a57600080fd5b50610a33611943565b6040518082815260200191505060405180910390f35b348015610a5557600080fd5b50610a5e611949565b6040518082815260200191505060405180910390f35b348015610a8057600080fd5b50610abf600480360381019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291908035906020019092919050505061194f565b604051808215151515815260200191505060405180910390f35b600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b6040805190810160405280600a81526020017f436172642773205761720000000000000000000000000000000000000000000081525081565b600160149054906101000a900460ff16151515610b5457600080fd5b610b5e33826119bb565b1515610b6957600080fd5b610b738183611a27565b7f8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b925338383604051808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001828152602001935050505060405180910390a15050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b6000610c566001600380549050611a7d90919063ffffffff16565b905090565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515610cb657600080fd5b600073ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff1614151515610cf257600080fd5b806000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161480610ddd5750600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16145b1515610de857600080fd5b61025863ffffffff1681101515610dfe57600080fd5b8060028190555050565b6000806000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515610e6657600080fd5b829050600073ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff161415610ec3576000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1690505b610ecf86868684611a96565b915050949350505050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515610f3557600080fd5b600160149054906101000a900460ff161515610f5057600080fd5b600073ffffffffffffffffffffffffffffffffffffffff16600760009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16141515610fad57600080fd5b610fb5611cb3565b565b600160149054906101000a900460ff16151515610fd357600080fd5b600073ffffffffffffffffffffffffffffffffffffffff168273ffffffffffffffffffffffffffffffffffffffff161415151561100f57600080fd5b3073ffffffffffffffffffffffffffffffffffffffff168273ffffffffffffffffffffffffffffffffffffffff161415151561104a57600080fd5b6110543382611d46565b151561105f57600080fd5b61106983826119bb565b151561107457600080fd5b61107f838383611db2565b505050565b600060608060006003805490506040519080825280602002602001820160405280156110bf5781602001602082028038833980820191505090505b509150600090505b60038054905081101561111e576003818154811015156110e357fe5b906000526020600020906005020160010154828281518110151561110357fe5b906020019060200201818152505080806001019150506110c7565b600380549050829350935050509091565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614151561118a57600080fd5b600073ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff16141515156111c657600080fd5b80600160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050565b60008060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614151561126757600080fd5b819050600073ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff1614156112c4576000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1690505b61c3506008541015156112d657600080fd5b6008600081548092919060010191905055506112f6600080600084611a96565b505050565b600160149054906101000a900460ff1681565b60006004600083815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff169050600073ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff161415151561138257600080fd5b919050565b600760009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b6000600560008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020549050919050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614151561145157600080fd5b600160149054906101000a900460ff16151561146c57600080fd5b80600760006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055507f450db8da6efbe9c22f2347f7c2021231df1fc58d3ae9a2fa75d39fa44619930581604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390a150565b60046020528060005260406000206000915054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b60025481565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614806115f45750600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16145b15156115ff57600080fd5b600160149054906101000a900460ff1615151561161b57600080fd5b60018060146101000a81548160ff021916908315150217905550565b606060006060600080600061164b876113ad565b9450600085141561168e5760006040519080825280602002602001820160405280156116865781602001602082028038833980820191505090505b50955061177a565b846040519080825280602002602001820160405280156116bd5781602001602082028038833980820191505090505b5093506116c8610c3b565b925060009150600190505b8281111515611776578673ffffffffffffffffffffffffffffffffffffffff166004600083815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1614156117695780848381518110151561175257fe5b906020019060200201818152505081806001019250505b80806001019150506116d3565b8395505b5050505050919050565b60066020528060005260406000206000915054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b6000806000806000806000806003898154811015156117d257fe5b906000526020600020906005020190508060040160009054906101000a900461ffff1661ffff16955080600001549750806002015492508060040160049054906101000a900460ff1660ff1693508060040160029054906101000a900461ffff1661ffff169450806001015496508060030154915050919395979092949650565b6040805190810160405280600381526020017f454757000000000000000000000000000000000000000000000000000000000081525081565b600160149054906101000a900460ff161515156118a857600080fd5b600073ffffffffffffffffffffffffffffffffffffffff168273ffffffffffffffffffffffffffffffffffffffff16141515156118e457600080fd5b3073ffffffffffffffffffffffffffffffffffffffff168273ffffffffffffffffffffffffffffffffffffffff161415151561191f57600080fd5b61192933826119bb565b151561193457600080fd5b61193f338383611db2565b5050565b60085481565b61c35081565b60008273ffffffffffffffffffffffffffffffffffffffff166006600084815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1614905092915050565b60008273ffffffffffffffffffffffffffffffffffffffff166004600084815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1614905092915050565b806006600084815260200190815260200160002060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055505050565b6000828211151515611a8b57fe5b818303905092915050565b600080611aa1612029565b8460ff168560ff16141515611ab557600080fd5b8687141515611ac357600080fd5b8586141515611ad157600080fd5b600380549050915060e0604051908101604052804267ffffffffffffffff168152602001838152602001888152602001878152602001600061ffff168152602001600061ffff1681526020018660ff168152509050600381908060018154018082558091505090600182039060005260206000209060050201600090919290919091506000820151816000015560208201518160010155604082015181600201556060820151816003015560808201518160040160006101000a81548161ffff021916908361ffff16021790555060a08201518160040160026101000a81548161ffff021916908361ffff16021790555060c08201518160040160046101000a81548160ff021916908360ff1602179055505050507eb33d4049e3604429ca215d9b3eab539effee6334feac24587f8fdbc34d7e4b848383604001518460600151856000015186608001518760c00151604051808873ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018781526020018681526020018581526020018481526020018361ffff1661ffff1681526020018260ff1660ff16815260200197505050505050505060405180910390a1611ca660008584611db2565b8192505050949350505050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515611d0e57600080fd5b600160149054906101000a900460ff161515611d2957600080fd5b6000600160146101000a81548160ff021916908315150217905550565b60008273ffffffffffffffffffffffffffffffffffffffff166006600084815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1614905092915050565b611e056001600560008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000205461200b90919063ffffffff16565b600560008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002081905550816004600083815260200190815260200160002060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550600073ffffffffffffffffffffffffffffffffffffffff168373ffffffffffffffffffffffffffffffffffffffff16141515611f6757611f236001600560008673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002054611a7d90919063ffffffff16565b600560008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020819055505b7fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef838383604051808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001828152602001935050505060405180910390a1505050565b600080828401905083811015151561201f57fe5b8091505092915050565b60e06040519081016040528060008152602001600081526020016000815260200160008152602001600061ffff168152602001600061ffff168152602001600060ff16815250905600a165627a7a72305820e415966044f05532384cf6086041611b909a5fe42e980862ac2aaed9cd3ce2f50029";

    public static final String FUNC_CFOADDRESS = "cfoAddress";

    public static final String FUNC_NAME = "name";

    public static final String FUNC_APPROVE = "approve";

    public static final String FUNC_CEOADDRESS = "ceoAddress";

    public static final String FUNC_TOTALSUPPLY = "totalSupply";

    public static final String FUNC_SETCEO = "setCEO";

    public static final String FUNC_SETSECONDSBLOCK = "setSecondsBlock";

    public static final String FUNC_CREATECARD = "createCard";

    public static final String FUNC_UNPAUSE = "unpause";

    public static final String FUNC_SAFETRANSFERFROM = "safeTransferFrom";

    public static final String FUNC_GETCARDINDEX = "getCardIndex";

    public static final String FUNC_SETCFO = "setCFO";

    public static final String FUNC_CREATEINITCARD = "createInitCard";

    public static final String FUNC_PAUSED = "paused";

    public static final String FUNC_OWNEROF = "ownerOf";

    public static final String FUNC_NEWCONTRACTADDRESS = "newContractAddress";

    public static final String FUNC_BALANCEOF = "balanceOf";

    public static final String FUNC_SETNEWADDRESS = "setNewAddress";

    public static final String FUNC_CARDINDEXTOOWNER = "cardIndexToOwner";

    public static final String FUNC_SECONDSPERBLOCK = "secondsPerBlock";

    public static final String FUNC_PAUSE = "pause";

    public static final String FUNC_TOKENSOFOWNER = "tokensOfOwner";

    public static final String FUNC_CARDSALESTOAPPROVED = "cardSalesToApproved";

    public static final String FUNC_GETCARD = "getCard";

    public static final String FUNC_SYMBOL = "symbol";

    public static final String FUNC_TRANSFER = "transfer";

    public static final String FUNC_CREATEDCOUNT = "createdCount";

    public static final String FUNC_CREATION_LIMIT = "CREATION_LIMIT";

    public static final String FUNC_ALLOWANCE = "allowance";

    public static final Event CONTRACTUPGRADE_EVENT = new Event("ContractUpgrade", 
            Arrays.<TypeReference<?>>asList(),
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
    ;

    public static final Event TRANSFER_EVENT = new Event("Transfer", 
            Arrays.<TypeReference<?>>asList(),
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event APPROVAL_EVENT = new Event("Approval", 
            Arrays.<TypeReference<?>>asList(),
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event CREATEDCARD_EVENT = new Event("CreatedCard", 
            Arrays.<TypeReference<?>>asList(),
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint16>() {}, new TypeReference<Uint8>() {}));
    ;

    protected EggCard(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected EggCard(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public RemoteCall<String> cfoAddress() {
        final Function function = new Function(FUNC_CFOADDRESS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> name() {
        final Function function = new Function(FUNC_NAME, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> approve(String _to, BigInteger _tokenId) {
        final Function function = new Function(
                FUNC_APPROVE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_to), 
                new org.web3j.abi.datatypes.generated.Uint256(_tokenId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> ceoAddress() {
        final Function function = new Function(FUNC_CEOADDRESS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<BigInteger> totalSupply() {
        final Function function = new Function(FUNC_TOTALSUPPLY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> setCEO(String _newCEO) {
        final Function function = new Function(
                FUNC_SETCEO, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_newCEO)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> setSecondsBlock(BigInteger secs) {
        final Function function = new Function(
                FUNC_SETSECONDSBLOCK, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(secs)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> createCard(BigInteger _eType, BigInteger _attrId, BigInteger _level, String _owner) {
        final Function function = new Function(
                FUNC_CREATECARD, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_eType), 
                new org.web3j.abi.datatypes.generated.Uint256(_attrId), 
                new org.web3j.abi.datatypes.generated.Uint8(_level), 
                new org.web3j.abi.datatypes.Address(_owner)), 
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

    public RemoteCall<TransactionReceipt> safeTransferFrom(String _from, String _to, BigInteger _tokenId) {
        final Function function = new Function(
                FUNC_SAFETRANSFERFROM, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_from), 
                new org.web3j.abi.datatypes.Address(_to), 
                new org.web3j.abi.datatypes.generated.Uint256(_tokenId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Tuple2<BigInteger, List<BigInteger>>> getCardIndex() {
        final Function function = new Function(FUNC_GETCARDINDEX, 
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

    public RemoteCall<TransactionReceipt> setCFO(String _newCFO) {
        final Function function = new Function(
                FUNC_SETCFO, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_newCFO)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> createInitCard(String _owner) {
        final Function function = new Function(
                FUNC_CREATEINITCARD, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_owner)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Boolean> paused() {
        final Function function = new Function(FUNC_PAUSED, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<String> ownerOf(BigInteger _tokenId) {
        final Function function = new Function(FUNC_OWNEROF, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_tokenId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> newContractAddress() {
        final Function function = new Function(FUNC_NEWCONTRACTADDRESS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<BigInteger> balanceOf(String _owner) {
        final Function function = new Function(FUNC_BALANCEOF, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_owner)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> setNewAddress(String _newAddress) {
        final Function function = new Function(
                FUNC_SETNEWADDRESS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_newAddress)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> cardIndexToOwner(BigInteger param0) {
        final Function function = new Function(FUNC_CARDINDEXTOOWNER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<BigInteger> secondsPerBlock() {
        final Function function = new Function(FUNC_SECONDSPERBLOCK, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> pause() {
        final Function function = new Function(
                FUNC_PAUSE, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<List> tokensOfOwner(String _owner) {
        final Function function = new Function(FUNC_TOKENSOFOWNER, 
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

    public RemoteCall<String> cardSalesToApproved(BigInteger param0) {
        final Function function = new Function(FUNC_CARDSALESTOAPPROVED, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<Tuple7<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger>> getCard(BigInteger _id) {
        final Function function = new Function(FUNC_GETCARD, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_id)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        return new RemoteCall<Tuple7<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger>>(
                new Callable<Tuple7<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger>>() {
                    @Override
                    public Tuple7<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple7<BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger>(
                                (BigInteger) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue(), 
                                (BigInteger) results.get(3).getValue(), 
                                (BigInteger) results.get(4).getValue(), 
                                (BigInteger) results.get(5).getValue(), 
                                (BigInteger) results.get(6).getValue());
                    }
                });
    }

    public RemoteCall<String> symbol() {
        final Function function = new Function(FUNC_SYMBOL, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> transfer(String _to, BigInteger _tokenId) {
        final Function function = new Function(
                FUNC_TRANSFER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_to), 
                new org.web3j.abi.datatypes.generated.Uint256(_tokenId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> createdCount() {
        final Function function = new Function(FUNC_CREATEDCOUNT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> CREATION_LIMIT() {
        final Function function = new Function(FUNC_CREATION_LIMIT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<Boolean> allowance(String _claimant, BigInteger _tokenId) {
        final Function function = new Function(FUNC_ALLOWANCE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_claimant), 
                new org.web3j.abi.datatypes.generated.Uint256(_tokenId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public static RemoteCall<EggCard> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _cfoAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_cfoAddress)));
        return deployRemoteCall(EggCard.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static RemoteCall<EggCard> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _cfoAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_cfoAddress)));
        return deployRemoteCall(EggCard.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public List<ContractUpgradeEventResponse> getContractUpgradeEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(CONTRACTUPGRADE_EVENT, transactionReceipt);
        ArrayList<ContractUpgradeEventResponse> responses = new ArrayList<ContractUpgradeEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ContractUpgradeEventResponse typedResponse = new ContractUpgradeEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.newContract = (String) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<ContractUpgradeEventResponse> contractUpgradeEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, ContractUpgradeEventResponse>() {
            @Override
            public ContractUpgradeEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(CONTRACTUPGRADE_EVENT, log);
                ContractUpgradeEventResponse typedResponse = new ContractUpgradeEventResponse();
                typedResponse.log = log;
                typedResponse.newContract = (String) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<ContractUpgradeEventResponse> contractUpgradeEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(CONTRACTUPGRADE_EVENT));
        return contractUpgradeEventObservable(filter);
    }

    public List<TransferEventResponse> getTransferEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(TRANSFER_EVENT, transactionReceipt);
        ArrayList<TransferEventResponse> responses = new ArrayList<TransferEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            TransferEventResponse typedResponse = new TransferEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.from = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.to = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.tokenId = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<TransferEventResponse> transferEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, TransferEventResponse>() {
            @Override
            public TransferEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(TRANSFER_EVENT, log);
                TransferEventResponse typedResponse = new TransferEventResponse();
                typedResponse.log = log;
                typedResponse.from = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.to = (String) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.tokenId = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<TransferEventResponse> transferEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(TRANSFER_EVENT));
        return transferEventObservable(filter);
    }

    public List<ApprovalEventResponse> getApprovalEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(APPROVAL_EVENT, transactionReceipt);
        ArrayList<ApprovalEventResponse> responses = new ArrayList<ApprovalEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ApprovalEventResponse typedResponse = new ApprovalEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.owner = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.approved = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.tokenId = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<ApprovalEventResponse> approvalEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, ApprovalEventResponse>() {
            @Override
            public ApprovalEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(APPROVAL_EVENT, log);
                ApprovalEventResponse typedResponse = new ApprovalEventResponse();
                typedResponse.log = log;
                typedResponse.owner = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.approved = (String) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.tokenId = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<ApprovalEventResponse> approvalEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(APPROVAL_EVENT));
        return approvalEventObservable(filter);
    }

    public List<CreatedCardEventResponse> getCreatedCardEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(CREATEDCARD_EVENT, transactionReceipt);
        ArrayList<CreatedCardEventResponse> responses = new ArrayList<CreatedCardEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            CreatedCardEventResponse typedResponse = new CreatedCardEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.owner = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.cardId = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.eType = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.attrId = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
            typedResponse.time = (BigInteger) eventValues.getNonIndexedValues().get(4).getValue();
            typedResponse.coolIndex = (BigInteger) eventValues.getNonIndexedValues().get(5).getValue();
            typedResponse.level = (BigInteger) eventValues.getNonIndexedValues().get(6).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<CreatedCardEventResponse> createdCardEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, CreatedCardEventResponse>() {
            @Override
            public CreatedCardEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(CREATEDCARD_EVENT, log);
                CreatedCardEventResponse typedResponse = new CreatedCardEventResponse();
                typedResponse.log = log;
                typedResponse.owner = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.cardId = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.eType = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
                typedResponse.attrId = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
                typedResponse.time = (BigInteger) eventValues.getNonIndexedValues().get(4).getValue();
                typedResponse.coolIndex = (BigInteger) eventValues.getNonIndexedValues().get(5).getValue();
                typedResponse.level = (BigInteger) eventValues.getNonIndexedValues().get(6).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<CreatedCardEventResponse> createdCardEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(CREATEDCARD_EVENT));
        return createdCardEventObservable(filter);
    }

    public static EggCard load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new EggCard(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static EggCard load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new EggCard(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static class ContractUpgradeEventResponse {
        public Log log;

        public String newContract;
    }

    public static class TransferEventResponse {
        public Log log;

        public String from;

        public String to;

        public BigInteger tokenId;
    }

    public static class ApprovalEventResponse {
        public Log log;

        public String owner;

        public String approved;

        public BigInteger tokenId;
    }

    public static class CreatedCardEventResponse {
        public Log log;

        public String owner;

        public BigInteger cardId;

        public BigInteger eType;

        public BigInteger attrId;

        public BigInteger time;

        public BigInteger coolIndex;

        public BigInteger level;
    }
}
