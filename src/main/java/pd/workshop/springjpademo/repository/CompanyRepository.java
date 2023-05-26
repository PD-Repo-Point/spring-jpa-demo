package pd.workshop.springjpademo.repository;

import pd.workshop.springjpademo.entity.Company;
import pd.workshop.springjpademo.entity.Employee;

import java.util.Optional;

public interface CompanyRepository {
    Optional<Company> save(Company company);
    Optional<Company> getCompanyById(Long id);
    void deleteCompany(Company company);
}
