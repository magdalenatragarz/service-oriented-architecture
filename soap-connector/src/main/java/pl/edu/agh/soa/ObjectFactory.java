
package pl.edu.agh.soa;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the pl.edu.agh.soa package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AddStudent_QNAME = new QName("http://soa.agh.edu.pl/", "addStudent");
    private final static QName _AddStudentResponse_QNAME = new QName("http://soa.agh.edu.pl/", "addStudentResponse");
    private final static QName _AddSubject_QNAME = new QName("http://soa.agh.edu.pl/", "addSubject");
    private final static QName _AddSubjectResponse_QNAME = new QName("http://soa.agh.edu.pl/", "addSubjectResponse");
    private final static QName _DownloadAvatar_QNAME = new QName("http://soa.agh.edu.pl/", "downloadAvatar");
    private final static QName _DownloadAvatarResponse_QNAME = new QName("http://soa.agh.edu.pl/", "downloadAvatarResponse");
    private final static QName _Erase_QNAME = new QName("http://soa.agh.edu.pl/", "erase");
    private final static QName _EraseResponse_QNAME = new QName("http://soa.agh.edu.pl/", "eraseResponse");
    private final static QName _FilterByName_QNAME = new QName("http://soa.agh.edu.pl/", "filterByName");
    private final static QName _FilterByNameResponse_QNAME = new QName("http://soa.agh.edu.pl/", "filterByNameResponse");
    private final static QName _FilterBySubject_QNAME = new QName("http://soa.agh.edu.pl/", "filterBySubject");
    private final static QName _FilterBySubjectResponse_QNAME = new QName("http://soa.agh.edu.pl/", "filterBySubjectResponse");
    private final static QName _FilterBySurname_QNAME = new QName("http://soa.agh.edu.pl/", "filterBySurname");
    private final static QName _FilterBySurnameResponse_QNAME = new QName("http://soa.agh.edu.pl/", "filterBySurnameResponse");
    private final static QName _FindByid_QNAME = new QName("http://soa.agh.edu.pl/", "findByid");
    private final static QName _FindByidResponse_QNAME = new QName("http://soa.agh.edu.pl/", "findByidResponse");
    private final static QName _GetStudents_QNAME = new QName("http://soa.agh.edu.pl/", "getStudents");
    private final static QName _GetStudentsResponse_QNAME = new QName("http://soa.agh.edu.pl/", "getStudentsResponse");
    private final static QName _GetSubjects_QNAME = new QName("http://soa.agh.edu.pl/", "getSubjects");
    private final static QName _GetSubjectsResponse_QNAME = new QName("http://soa.agh.edu.pl/", "getSubjectsResponse");
    private final static QName _RemoveStudent_QNAME = new QName("http://soa.agh.edu.pl/", "removeStudent");
    private final static QName _RemoveStudentResponse_QNAME = new QName("http://soa.agh.edu.pl/", "removeStudentResponse");
    private final static QName _UploadAvatar_QNAME = new QName("http://soa.agh.edu.pl/", "uploadAvatar");
    private final static QName _UploadAvatarResponse_QNAME = new QName("http://soa.agh.edu.pl/", "uploadAvatarResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: pl.edu.agh.soa
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Student }
     * 
     */
    public Student createStudent() {
        return new Student();
    }

    /**
     * Create an instance of {@link AddStudent }
     * 
     */
    public AddStudent createAddStudent() {
        return new AddStudent();
    }

    /**
     * Create an instance of {@link AddStudentResponse }
     * 
     */
    public AddStudentResponse createAddStudentResponse() {
        return new AddStudentResponse();
    }

    /**
     * Create an instance of {@link AddSubject }
     * 
     */
    public AddSubject createAddSubject() {
        return new AddSubject();
    }

    /**
     * Create an instance of {@link AddSubjectResponse }
     * 
     */
    public AddSubjectResponse createAddSubjectResponse() {
        return new AddSubjectResponse();
    }

    /**
     * Create an instance of {@link DownloadAvatar }
     * 
     */
    public DownloadAvatar createDownloadAvatar() {
        return new DownloadAvatar();
    }

    /**
     * Create an instance of {@link DownloadAvatarResponse }
     * 
     */
    public DownloadAvatarResponse createDownloadAvatarResponse() {
        return new DownloadAvatarResponse();
    }

    /**
     * Create an instance of {@link Erase }
     * 
     */
    public Erase createErase() {
        return new Erase();
    }

    /**
     * Create an instance of {@link EraseResponse }
     * 
     */
    public EraseResponse createEraseResponse() {
        return new EraseResponse();
    }

    /**
     * Create an instance of {@link FilterByName }
     * 
     */
    public FilterByName createFilterByName() {
        return new FilterByName();
    }

    /**
     * Create an instance of {@link FilterByNameResponse }
     * 
     */
    public FilterByNameResponse createFilterByNameResponse() {
        return new FilterByNameResponse();
    }

    /**
     * Create an instance of {@link FilterBySubject }
     * 
     */
    public FilterBySubject createFilterBySubject() {
        return new FilterBySubject();
    }

    /**
     * Create an instance of {@link FilterBySubjectResponse }
     * 
     */
    public FilterBySubjectResponse createFilterBySubjectResponse() {
        return new FilterBySubjectResponse();
    }

    /**
     * Create an instance of {@link FilterBySurname }
     * 
     */
    public FilterBySurname createFilterBySurname() {
        return new FilterBySurname();
    }

    /**
     * Create an instance of {@link FilterBySurnameResponse }
     * 
     */
    public FilterBySurnameResponse createFilterBySurnameResponse() {
        return new FilterBySurnameResponse();
    }

    /**
     * Create an instance of {@link FindByid }
     * 
     */
    public FindByid createFindByid() {
        return new FindByid();
    }

    /**
     * Create an instance of {@link FindByidResponse }
     * 
     */
    public FindByidResponse createFindByidResponse() {
        return new FindByidResponse();
    }

    /**
     * Create an instance of {@link GetStudents }
     * 
     */
    public GetStudents createGetStudents() {
        return new GetStudents();
    }

    /**
     * Create an instance of {@link GetStudentsResponse }
     * 
     */
    public GetStudentsResponse createGetStudentsResponse() {
        return new GetStudentsResponse();
    }

    /**
     * Create an instance of {@link GetSubjects }
     * 
     */
    public GetSubjects createGetSubjects() {
        return new GetSubjects();
    }

    /**
     * Create an instance of {@link GetSubjectsResponse }
     * 
     */
    public GetSubjectsResponse createGetSubjectsResponse() {
        return new GetSubjectsResponse();
    }

    /**
     * Create an instance of {@link RemoveStudent }
     * 
     */
    public RemoveStudent createRemoveStudent() {
        return new RemoveStudent();
    }

    /**
     * Create an instance of {@link RemoveStudentResponse }
     * 
     */
    public RemoveStudentResponse createRemoveStudentResponse() {
        return new RemoveStudentResponse();
    }

    /**
     * Create an instance of {@link UploadAvatar }
     * 
     */
    public UploadAvatar createUploadAvatar() {
        return new UploadAvatar();
    }

    /**
     * Create an instance of {@link UploadAvatarResponse }
     * 
     */
    public UploadAvatarResponse createUploadAvatarResponse() {
        return new UploadAvatarResponse();
    }

    /**
     * Create an instance of {@link Subject }
     * 
     */
    public Subject createSubject() {
        return new Subject();
    }

    /**
     * Create an instance of {@link Student.Subjects }
     * 
     */
    public Student.Subjects createStudentSubjects() {
        return new Student.Subjects();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddStudent }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddStudent }{@code >}
     */
    @XmlElementDecl(namespace = "http://soa.agh.edu.pl/", name = "addStudent")
    public JAXBElement<AddStudent> createAddStudent(AddStudent value) {
        return new JAXBElement<AddStudent>(_AddStudent_QNAME, AddStudent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddStudentResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddStudentResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://soa.agh.edu.pl/", name = "addStudentResponse")
    public JAXBElement<AddStudentResponse> createAddStudentResponse(AddStudentResponse value) {
        return new JAXBElement<AddStudentResponse>(_AddStudentResponse_QNAME, AddStudentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddSubject }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddSubject }{@code >}
     */
    @XmlElementDecl(namespace = "http://soa.agh.edu.pl/", name = "addSubject")
    public JAXBElement<AddSubject> createAddSubject(AddSubject value) {
        return new JAXBElement<AddSubject>(_AddSubject_QNAME, AddSubject.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddSubjectResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddSubjectResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://soa.agh.edu.pl/", name = "addSubjectResponse")
    public JAXBElement<AddSubjectResponse> createAddSubjectResponse(AddSubjectResponse value) {
        return new JAXBElement<AddSubjectResponse>(_AddSubjectResponse_QNAME, AddSubjectResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DownloadAvatar }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DownloadAvatar }{@code >}
     */
    @XmlElementDecl(namespace = "http://soa.agh.edu.pl/", name = "downloadAvatar")
    public JAXBElement<DownloadAvatar> createDownloadAvatar(DownloadAvatar value) {
        return new JAXBElement<DownloadAvatar>(_DownloadAvatar_QNAME, DownloadAvatar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DownloadAvatarResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DownloadAvatarResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://soa.agh.edu.pl/", name = "downloadAvatarResponse")
    public JAXBElement<DownloadAvatarResponse> createDownloadAvatarResponse(DownloadAvatarResponse value) {
        return new JAXBElement<DownloadAvatarResponse>(_DownloadAvatarResponse_QNAME, DownloadAvatarResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Erase }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Erase }{@code >}
     */
    @XmlElementDecl(namespace = "http://soa.agh.edu.pl/", name = "erase")
    public JAXBElement<Erase> createErase(Erase value) {
        return new JAXBElement<Erase>(_Erase_QNAME, Erase.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EraseResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EraseResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://soa.agh.edu.pl/", name = "eraseResponse")
    public JAXBElement<EraseResponse> createEraseResponse(EraseResponse value) {
        return new JAXBElement<EraseResponse>(_EraseResponse_QNAME, EraseResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FilterByName }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FilterByName }{@code >}
     */
    @XmlElementDecl(namespace = "http://soa.agh.edu.pl/", name = "filterByName")
    public JAXBElement<FilterByName> createFilterByName(FilterByName value) {
        return new JAXBElement<FilterByName>(_FilterByName_QNAME, FilterByName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FilterByNameResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FilterByNameResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://soa.agh.edu.pl/", name = "filterByNameResponse")
    public JAXBElement<FilterByNameResponse> createFilterByNameResponse(FilterByNameResponse value) {
        return new JAXBElement<FilterByNameResponse>(_FilterByNameResponse_QNAME, FilterByNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FilterBySubject }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FilterBySubject }{@code >}
     */
    @XmlElementDecl(namespace = "http://soa.agh.edu.pl/", name = "filterBySubject")
    public JAXBElement<FilterBySubject> createFilterBySubject(FilterBySubject value) {
        return new JAXBElement<FilterBySubject>(_FilterBySubject_QNAME, FilterBySubject.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FilterBySubjectResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FilterBySubjectResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://soa.agh.edu.pl/", name = "filterBySubjectResponse")
    public JAXBElement<FilterBySubjectResponse> createFilterBySubjectResponse(FilterBySubjectResponse value) {
        return new JAXBElement<FilterBySubjectResponse>(_FilterBySubjectResponse_QNAME, FilterBySubjectResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FilterBySurname }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FilterBySurname }{@code >}
     */
    @XmlElementDecl(namespace = "http://soa.agh.edu.pl/", name = "filterBySurname")
    public JAXBElement<FilterBySurname> createFilterBySurname(FilterBySurname value) {
        return new JAXBElement<FilterBySurname>(_FilterBySurname_QNAME, FilterBySurname.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FilterBySurnameResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FilterBySurnameResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://soa.agh.edu.pl/", name = "filterBySurnameResponse")
    public JAXBElement<FilterBySurnameResponse> createFilterBySurnameResponse(FilterBySurnameResponse value) {
        return new JAXBElement<FilterBySurnameResponse>(_FilterBySurnameResponse_QNAME, FilterBySurnameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindByid }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FindByid }{@code >}
     */
    @XmlElementDecl(namespace = "http://soa.agh.edu.pl/", name = "findByid")
    public JAXBElement<FindByid> createFindByid(FindByid value) {
        return new JAXBElement<FindByid>(_FindByid_QNAME, FindByid.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindByidResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FindByidResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://soa.agh.edu.pl/", name = "findByidResponse")
    public JAXBElement<FindByidResponse> createFindByidResponse(FindByidResponse value) {
        return new JAXBElement<FindByidResponse>(_FindByidResponse_QNAME, FindByidResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudents }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetStudents }{@code >}
     */
    @XmlElementDecl(namespace = "http://soa.agh.edu.pl/", name = "getStudents")
    public JAXBElement<GetStudents> createGetStudents(GetStudents value) {
        return new JAXBElement<GetStudents>(_GetStudents_QNAME, GetStudents.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentsResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetStudentsResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://soa.agh.edu.pl/", name = "getStudentsResponse")
    public JAXBElement<GetStudentsResponse> createGetStudentsResponse(GetStudentsResponse value) {
        return new JAXBElement<GetStudentsResponse>(_GetStudentsResponse_QNAME, GetStudentsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSubjects }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetSubjects }{@code >}
     */
    @XmlElementDecl(namespace = "http://soa.agh.edu.pl/", name = "getSubjects")
    public JAXBElement<GetSubjects> createGetSubjects(GetSubjects value) {
        return new JAXBElement<GetSubjects>(_GetSubjects_QNAME, GetSubjects.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSubjectsResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetSubjectsResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://soa.agh.edu.pl/", name = "getSubjectsResponse")
    public JAXBElement<GetSubjectsResponse> createGetSubjectsResponse(GetSubjectsResponse value) {
        return new JAXBElement<GetSubjectsResponse>(_GetSubjectsResponse_QNAME, GetSubjectsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveStudent }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RemoveStudent }{@code >}
     */
    @XmlElementDecl(namespace = "http://soa.agh.edu.pl/", name = "removeStudent")
    public JAXBElement<RemoveStudent> createRemoveStudent(RemoveStudent value) {
        return new JAXBElement<RemoveStudent>(_RemoveStudent_QNAME, RemoveStudent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveStudentResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RemoveStudentResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://soa.agh.edu.pl/", name = "removeStudentResponse")
    public JAXBElement<RemoveStudentResponse> createRemoveStudentResponse(RemoveStudentResponse value) {
        return new JAXBElement<RemoveStudentResponse>(_RemoveStudentResponse_QNAME, RemoveStudentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UploadAvatar }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UploadAvatar }{@code >}
     */
    @XmlElementDecl(namespace = "http://soa.agh.edu.pl/", name = "uploadAvatar")
    public JAXBElement<UploadAvatar> createUploadAvatar(UploadAvatar value) {
        return new JAXBElement<UploadAvatar>(_UploadAvatar_QNAME, UploadAvatar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UploadAvatarResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UploadAvatarResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://soa.agh.edu.pl/", name = "uploadAvatarResponse")
    public JAXBElement<UploadAvatarResponse> createUploadAvatarResponse(UploadAvatarResponse value) {
        return new JAXBElement<UploadAvatarResponse>(_UploadAvatarResponse_QNAME, UploadAvatarResponse.class, null, value);
    }

}
