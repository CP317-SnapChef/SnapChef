//
//  dropDownBtn.swift
//  SnapChef
//
//  Created by Dylan Clarry on 2018-12-16.
//  Copyright © 2018 SnapChefTeam. All rights reserved.
//

// NOTE: THIS DID NOT WORK AND WAS LEFT OUT OF THE APP FOR PRESENTATION

//import Foundation
//
//protocol dropDownProtocol {
//    func dropDownPressed(string: String)
//}
//
//class dropDownBtn: UIButton, dropDownProtocol {
//
//    func dropDownPressed(string: String) {
//        self.setTitle(string, for: .normal)
//    }
//
//    var dropView = dropDownView()
//    var height = NSLayoutConstraint()
//
//    override init(frame: CGRect) {
//        super.init(frame: frame)
//
//        self.backgroundColor = UIColor.colorDarkOrange
//
//        dropView = dropDownView.init(frame: CGRect.init(x: 0, y: 0, width: 0, height: 0))
//        dropView.delegate = self
//        dropView.translatesAutoresizingMaskIntoConstraints = false
//    }
//
//    override func didMoveToSuperview() {
//        self.superview?.addSubview(dropView)
//        self.superview?.bringSubviewToFront(dropView)
//        dropView.topAnchor.constraint(equalTo: self.bottomAnchor).isActive = true
//        dropView.centerXAnchor.constraint(equalTo: self.centerXAnchor).isActive = true
//        dropView.widthAnchor.constraint(equalTo: self.widthAnchor).isActive = true
//        height = dropView.heightAnchor.constraint(equalToConstant: 0)
//    }
//
//    var isOpen = false
//    override func touchesBegan(_ touches: Set<UITouch>, with event: UIEvent?) {
//        if isOpen == false {
//
//            isOpen = true
//
//            NSLayoutConstraint.deactivate([self.height])
//            if self.dropView.tableView.contentSize.height > 130 {
//                self.height.constant = 130
//            } else {
//                self.height.constant = self.dropView.tableView.contentSize.height
//            }
//            NSLayoutConstraint.activate([self.height])
//
//            UIView.animate(withDuration: 0.5, delay: 0, usingSpringWithDamping: 0.5, initialSpringVelocity: 0.5, options: .curveEaseInOut, animations: {
//                self.dropView.layoutIfNeeded()
//                self.dropView.center.y += self.dropView.frame.height / 2
//            }, completion: nil)
//        } else {
//            isOpen = false
//
//            NSLayoutConstraint.deactivate([self.height])
//            self.height.constant = 0
//            NSLayoutConstraint.activate([self.height])
//
//            UIView.animate(withDuration: 0.5, delay: 0, usingSpringWithDamping: 0.5, initialSpringVelocity: 0.5, options: .curveEaseInOut, animations: {
//                self.dropView.center.y -= self.dropView.frame.height / 2
//                self.dropView.layoutIfNeeded()
//            }, completion: nil)
//        }
//    }
//
//    required init?(coder aDecoder: NSCoder) {
//        fatalError("init(coder:) has not been implemented")
//    }
//}
//
//class dropDownView: UIView, UITableViewDelegate, UITableViewDataSource {
//
//    var dropDownOptions = [String]()
//
//    var tableView = UITableView()
//
//    var delegate : dropDownProtocol!
//
//    override init(frame: CGRect) {
//        super.init(frame: frame)
//
//        tableView.backgroundColor = UIColor.colorOrange
//        self.backgroundColor = UIColor.colorOrange
//
//        tableView.delegate = self
//        tableView.dataSource = self
//        tableView.separatorStyle = .none
//
//        tableView.translatesAutoresizingMaskIntoConstraints = false
//
//        self.addSubview(tableView)
//
//        tableView.leftAnchor.constraint(equalTo: self.leftAnchor).isActive = true
//        tableView.rightAnchor.constraint(equalTo: self.rightAnchor).isActive = true
//        tableView.topAnchor.constraint(equalTo: self.topAnchor).isActive = true
//        tableView.bottomAnchor.constraint(equalTo: self.bottomAnchor).isActive = true
//    }
//
//    required init?(coder aDecoder: NSCoder) {
//        fatalError("init(coder:) has not been implemented")
//    }
//
//    func numberOfSections(in tableView: UITableView) -> Int {
//        return 1
//    }
//
//    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
//        return dropDownOptions.count
//    }
//
//    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
//        let cell = UITableViewCell()
//
//        cell.textLabel?.text = dropDownOptions[indexPath.row]
//        cell.backgroundColor = UIColor.colorOrange
//        return cell
//    }
//
//    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
//        self.delegate.dropDownPressed(string: dropDownOptions[indexPath.row])
//    }
//}
