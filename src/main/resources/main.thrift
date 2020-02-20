typedef i32 int
typedef i64 long
typedef string String
struct Name{
1:String salutation,
2:String firstName,
3:String secondName,
4:String thirdName
}

struct Address{
1:list<String> addressLine,
2:String city,
3:String dist,
4:String state,
5:String pincode
}

struct CersaiResponseDto{
1:long leadId,
2:Name name,
3:String motherName,
4:String fatherName,
5:String gender,
6:String maritalStatus,
7:String nationality,
8:String pan,
9:Address address,
10:String pincode,
11:String email
}

enum CersaiRequestSource {
MERCHANT_LENDING       = 0
POSTPAID               = 1
}

exception IOException {
1:long serialVersionUID=7818375828146090155
}

exception CersaiDataMismatchException {
1:String reason
}

exception CersaiDobMismatchException{
}

service downloadCersaiCKYCReportService{
CersaiResponseDto downloadCersaiCKYCReport(1:String ckycId,2:String dob,3:int retryCount,4:CersaiRequestSource source) throws(1:IOException ioException,2:CersaiDataMismatchException cersaiDataMismatchException,3:CersaiDobMismatchException cersaiDobMismatchException);
}